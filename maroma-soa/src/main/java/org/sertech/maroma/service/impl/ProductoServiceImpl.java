package org.sertech.maroma.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sertech.maroma.canonical.ProductoCanonicalRequest;
import org.sertech.maroma.canonical.ProductoCanonicalResponse;
import org.sertech.maroma.domain.ProductoEntity;
import org.sertech.maroma.dto.ProductoDTO;
import org.sertech.maroma.repository.ProductoRepository;
import org.sertech.maroma.service.ProductoService;
import org.sertech.maroma.utils.ConstantesGenericas;
import org.sertech.maroma.utils.ResponseMensajeContantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ma.glasnost.orika.MapperFacade;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
    private ProductoRepository productoRepository;
	
	@Autowired
	private MapperFacade mapperFacade;

	@Override
	public ProductoCanonicalResponse buscarProductoByDescription(ProductoCanonicalRequest request) {
		
		ProductoCanonicalResponse response = new ProductoCanonicalResponse();
		List<ProductoEntity> listaProductos = productoRepository.buscarProductoByDescription(
				request.getProductoDto().getDescripcion());
		Map<String, Object> reponseMap = new HashMap<>();
		if(!CollectionUtils.isEmpty(listaProductos)){
			List<ProductoDTO> productDtoList = convertirAProductoDto(listaProductos);
			reponseMap.put(ConstantesGenericas.PARAMETER_PRODUCTOS, productDtoList);
		}
		reponseMap.put("message", ResponseMensajeContantes.SERVICE_RESPONSE_OK);
		response.setData(reponseMap);
		return response;
	}

	private List<ProductoDTO> convertirAProductoDto(List<ProductoEntity> listaProductos) {
		List<ProductoDTO> productDtoList = new ArrayList<>();
		for(ProductoEntity producto : listaProductos){
			ProductoDTO productoDto = mapperFacade.map(producto, ProductoDTO.class);
			productDtoList.add(productoDto);
		}
		return productDtoList;
	}
}
