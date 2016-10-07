package org.sertech.maroma.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.sertech.maroma.canonical.ComprobanteCanonicalRequest;
import org.sertech.maroma.canonical.ComprobanteCanonicalResponse;
import org.sertech.maroma.domain.ClienteEntity;
import org.sertech.maroma.domain.ComprobanteEntity;
import org.sertech.maroma.domain.DetalleComprobanteEntity;
import org.sertech.maroma.domain.PrecioProductoEntity;
import org.sertech.maroma.repository.ComprobanteRepository;
import org.sertech.maroma.repository.DetalleComprobanteRepository;
import org.sertech.maroma.repository.PrecioProductoRepository;
import org.sertech.maroma.service.ComprobanteService;
import org.sertech.maroma.utils.ConstantesGenericas;
import org.sertech.maroma.utils.ResponseMensajeContantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Service
public class ComprobanteServiceImpl implements ComprobanteService {

	@Autowired
	private ComprobanteRepository comprobanteRepository;
	
	@Autowired
	private PrecioProductoRepository precioProductoRepository;
	
	@Autowired
	private DetalleComprobanteRepository detalleComprobanteRepository;
	
	@Override
	public ComprobanteCanonicalResponse guardarComprobante(ComprobanteCanonicalRequest request) {
		ComprobanteCanonicalResponse response = new ComprobanteCanonicalResponse();
		
		if(request.getParametros()!=null){
			
			// get cliente
			ClienteEntity cliente = new ClienteEntity();
			cliente.setId(Long.parseLong((String)request.getParametros().
					get(ConstantesGenericas.PARAMETER_ID_CLIENTE)));
			
			// get detalleComprobanteList
			List<DetalleComprobanteEntity> listaDetalleComprobante = 
					obtenerListaComprobanteEntity(request.getParametros());
			
			// build comprobate Entity
			ComprobanteEntity comprobante = new ComprobanteEntity();
			comprobante.setEstado(ConstantesGenericas.ACTIVO);
			comprobante.setClienteId(cliente);
			BigDecimal totalAmount = obtenerMontoTotal(listaDetalleComprobante);
			if(!totalAmount.equals(BigDecimal.ZERO)){
				comprobante.setMontoTotal(obtenerMontoTotal(listaDetalleComprobante));
				Date instant = new Date();
		    	Timestamp fechaEmision = new Timestamp(instant.getTime());
				comprobante.setFechaDeEmision(fechaEmision);
				comprobante = comprobanteRepository.save(comprobante);
				
				// save comprobante details
				for(DetalleComprobanteEntity item : listaDetalleComprobante){
					item.setComprobanteId(comprobante);
					detalleComprobanteRepository.save(item);
				}
			}
		}
		return response;
	}

	private List<DetalleComprobanteEntity> obtenerListaComprobanteEntity(Map<String, Object> parametros) {
		
		List<Map<String,String>> lista = (List<Map<String,String>>)parametros.
				get(ConstantesGenericas.PARAMETER_DETALLE_COMPROBANTE);
		List<DetalleComprobanteEntity> listaDetalleComprobante = new ArrayList<>();
		if(!CollectionUtils.isEmpty(lista)){
			for(Map<String,String> item : lista){
				long productoId = Long.parseLong(item.get(ConstantesGenericas.PARAMETER_ID_PRODUCTO));
				if(productoId>0){
					DetalleComprobanteEntity detalleComprobante = new DetalleComprobanteEntity();
					PrecioProductoEntity precio = precioProductoRepository.buscarPrecioVigentePorProducto(productoId);
					detalleComprobante.setPrecioProductoId(precio);
					int cantidad = Integer.parseInt(item.get(ConstantesGenericas.PARAMETER_CANTIDAD_PRODUCTO));
					detalleComprobante.setCantidad(cantidad);
					detalleComprobante.setMonto(precio.getPrecioUnitario().
							multiply(new BigDecimal(cantidad)));
					listaDetalleComprobante.add(detalleComprobante);
				}
			}
		}
		return listaDetalleComprobante;
	}

	private BigDecimal obtenerMontoTotal(List<DetalleComprobanteEntity> listaDetalleComprobante) {
		BigDecimal total = BigDecimal.ZERO;
		for(DetalleComprobanteEntity detalleComprobante : listaDetalleComprobante){
			total = total.add(detalleComprobante.getMonto());
		}
		return total;
	}
	
	@Override
	public ComprobanteCanonicalResponse eliminarComprobante(ComprobanteCanonicalRequest response) {
		
		return null;
	}

}
