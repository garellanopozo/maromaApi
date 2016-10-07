package org.sertech.maroma.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sertech.maroma.canonical.PrecioProductoCanonicalRequest;
import org.sertech.maroma.canonical.PrecioProductoCanonicalResponse;
import org.sertech.maroma.domain.PrecioProductoEntity;
import org.sertech.maroma.dto.PrecioProductoDTO;
import org.sertech.maroma.repository.PrecioProductoRepository;
import org.sertech.maroma.service.PrecioProductoService;
import org.sertech.maroma.utils.ConstantesGenericas;
import org.sertech.maroma.utils.ResponseMensajeContantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.glasnost.orika.MapperFacade;

@Service
public class PrecioProductoServiceImpl implements PrecioProductoService {

	@Autowired
    private PrecioProductoRepository precioProductoRepository;
	
	@Autowired
	private MapperFacade mapperFacade;

	@Override
	public PrecioProductoCanonicalResponse buscarProductoByDescription(PrecioProductoCanonicalRequest request) {
		PrecioProductoCanonicalResponse response = new PrecioProductoCanonicalResponse();
		Map<String, Object> data = new HashMap<>();
		List<PrecioProductoEntity> precioProductoDtolist = 
				precioProductoRepository.buscarPrecioVigentePorDescripcionProducto(
						request.getPrecioProductoDto().getDescripcionProducto());
		List<PrecioProductoDTO> precioProductoDtoList = convertirADto(precioProductoDtolist);
		data.put(ConstantesGenericas.PARAMETER_PRODUCTOS, precioProductoDtoList);
		data.put("message", ResponseMensajeContantes.SERVICE_RESPONSE_OK);
		response.setData(data);
		return response;
	}

	private List<PrecioProductoDTO> convertirADto(List<PrecioProductoEntity> precioProductolist) {
		List<PrecioProductoDTO> precioProductoDtolist = new ArrayList<>();
		for(PrecioProductoEntity entity : precioProductolist){
			PrecioProductoDTO dto = mapperFacade.map(entity, PrecioProductoDTO.class);
			precioProductoDtolist.add(dto);
		}
		return precioProductoDtolist;
	}

}
