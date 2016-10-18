package org.sertech.maroma.rest;

import java.util.Map;

import org.sertech.maroma.canonical.ProductoCanonicalRequest;
import org.sertech.maroma.canonical.ProductoCanonicalResponse;
import org.sertech.maroma.dto.ProductoDTO;
import org.sertech.maroma.service.ProductoService;
import org.sertech.maroma.utils.ConstantesGenericas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/api/maroma")
public class ProductoController extends BaseController{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductoService productoService;

	@RequestMapping(value = "/buscarProducto", 
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String findProducto(@RequestBody Map<String, String> requestMap) {

		ProductoCanonicalRequest productoCanonicalRequest = getProductoCanonicalRequest(requestMap);
		ProductoCanonicalResponse productoCanonicalResponse = productoService.buscarProductoByDescription(productoCanonicalRequest);
		String response = convertirJson(productoCanonicalResponse);
		logger.debug("response body : " + response);
		return response;
	}

	private ProductoCanonicalRequest getProductoCanonicalRequest(Map<String, String> requestMap) {
		ProductoCanonicalRequest request = new ProductoCanonicalRequest();
		ProductoDTO productoDto = new ProductoDTO();
		String descripcion = requestMap.get(ConstantesGenericas.PARAMETER_DESCRIPCION_PRODUCTO);
		productoDto.setDescripcion(descripcion);
		request.setProductoDto(productoDto);
		return request;
	}
}
