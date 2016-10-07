package org.sertech.maroma.rest;

import org.sertech.maroma.canonical.CategoriaCanonicalRequest;
import org.sertech.maroma.canonical.CategoriaCanonicalResponse;
import org.sertech.maroma.service.CategoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/maroma")
public class CategoriaController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value = "/guardarCategoria", method = RequestMethod.POST)
	@ResponseBody
	public CategoriaCanonicalResponse guardarCategoria(@RequestBody CategoriaCanonicalRequest request) {
		logger.debug("request body :" + request);
		CategoriaCanonicalResponse response = null;
		if (request != null) {
			response = categoriaService.guardarCategoria(request);
		}
		logger.debug("response body : " + response);
		return response;
	}

	@RequestMapping(value = "/eliminarCategoria", method = RequestMethod.POST)
	@ResponseBody
	public CategoriaCanonicalResponse eliminarCategoria(@RequestBody CategoriaCanonicalRequest categoriaCanonical) {
		logger.debug("request body :" + categoriaCanonical);
		CategoriaCanonicalResponse response = null;
		if (categoriaCanonical.getId() != null) {
			response = categoriaService.eliminarCategoria(categoriaCanonical);
		}
		logger.debug("response body : " + response);
		return response;
	}
}
