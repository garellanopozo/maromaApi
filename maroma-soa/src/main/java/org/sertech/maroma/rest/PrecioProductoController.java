package org.sertech.maroma.rest;

import java.util.Map;

import org.sertech.maroma.canonical.PrecioProductoCanonicalRequest;
import org.sertech.maroma.canonical.PrecioProductoCanonicalResponse;
import org.sertech.maroma.dto.PrecioProductoDTO;
import org.sertech.maroma.service.PrecioProductoService;
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
public class PrecioProductoController extends BaseController{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PrecioProductoService precioProductoService;

	@RequestMapping(value = "/buscarProductoConPrecio", 
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String findProducto(@RequestBody Map<String, String> requestMap) {

		PrecioProductoCanonicalRequest precioProductoCanonicalRequest = 
				getPrecioProductoCanonicalRequest(requestMap);
		PrecioProductoCanonicalResponse precioProductoCanonicalResponse = 
				precioProductoService.buscarProductoByDescription(precioProductoCanonicalRequest);
		String response = convertirJson(precioProductoCanonicalResponse);
		logger.debug("response body : " + response);
		return response;
	}

	private PrecioProductoCanonicalRequest getPrecioProductoCanonicalRequest(Map<String, String> requestMap) {
		PrecioProductoCanonicalRequest request = new PrecioProductoCanonicalRequest();
		String descripcion = requestMap.get(ConstantesGenericas.PARAMETER_DESCRIPCION_PRODUCTO);
		PrecioProductoDTO precioProductoDto = new PrecioProductoDTO();
		precioProductoDto.setDescripcionProducto(descripcion);
		request.setPrecioProductoDto(precioProductoDto);
		return request;
	}
}
