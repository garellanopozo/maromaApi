package org.sertech.maroma.rest;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import org.sertech.maroma.canonical.CategoriaCanonicalRequest;
import org.sertech.maroma.canonical.CategoriaCanonicalResponse;
import org.sertech.maroma.canonical.ClienteCanonicalRequest;
import org.sertech.maroma.canonical.ClienteCanonicalResponse;
import org.sertech.maroma.canonical.ComprobanteCanonicalRequest;
import org.sertech.maroma.canonical.ComprobanteCanonicalResponse;
import org.sertech.maroma.canonical.ProductoCanonicalRequest;
import org.sertech.maroma.canonical.ProductoCanonicalResponse;
import org.sertech.maroma.service.CategoriaService;
import org.sertech.maroma.service.ClienteService;
import org.sertech.maroma.service.ComprobanteService;
import org.sertech.maroma.service.ProductoService;
import org.sertech.maroma.utils.ConstantesGenericas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by German on 28/07/2016.
 */

@Controller
@RequestMapping("/api/maroma")
public class MaromaRestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductoService productoService;

	@Autowired
	private ComprobanteService comprobanteService;

	

	/*
	 * Producto Services
	 */
	@RequestMapping(value = "/guardarProducto", method = RequestMethod.POST)
	@ResponseBody
	public ProductoCanonicalResponse guardarProduct(@RequestBody ProductoCanonicalRequest request) {
		logger.debug("request body :" + request);

		ProductoCanonicalResponse response = null;
		if (request != null) {
			response = productoService.agregarProducto(request);
		}
		logger.debug("response body : " + response);
		return response;
	}

	@RequestMapping(value = "/eliminarProducto", method = RequestMethod.POST)
	@ResponseBody
	public ProductoCanonicalResponse eliminarProducto(@RequestBody ProductoCanonicalRequest request) {
		logger.debug("request body :" + request);

		ProductoCanonicalResponse response = null;
		if (request.getId() != null) {
			response = productoService.eliminarProducto(request);
		}
		logger.debug("response body : " + response);
		return response;
	}

	@RequestMapping(value = "/buscarProducto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String findProducto(@RequestBody Map<String, String> requestMap) {

		Map<String, Object> mapa = new HashMap<>();
		mapa.put("data", productoService.buscarProductoByDescription(requestMap));
		Gson gson = new Gson();
		String response = gson.toJson(mapa);
		logger.debug("response body : " + response);
		return response;
	}

	/*
	 * Comprobante Services
	 */
	@RequestMapping(value = "/guardarComprobante", method = RequestMethod.POST)
	@ResponseBody
	public ComprobanteCanonicalResponse guardarComprobante(@RequestBody ComprobanteCanonicalRequest request) {
		logger.debug("request body :" + request);
		ComprobanteCanonicalResponse response = null;
		if (request != null) {
			response = comprobanteService.guardarComprobante(request);
		}
		logger.debug("response body : " + response);
		return response;
	}
}
