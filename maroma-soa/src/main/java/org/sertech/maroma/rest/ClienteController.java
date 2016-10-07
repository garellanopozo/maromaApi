package org.sertech.maroma.rest;

import java.util.HashMap;
import java.util.Map;

import org.sertech.maroma.canonical.CategoriaCanonicalRequest;
import org.sertech.maroma.canonical.CategoriaCanonicalResponse;
import org.sertech.maroma.canonical.ClienteCanonicalRequest;
import org.sertech.maroma.canonical.ClienteCanonicalResponse;
import org.sertech.maroma.dto.ClienteDTO;
import org.sertech.maroma.service.CategoriaService;
import org.sertech.maroma.service.ClienteService;
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

import com.google.gson.Gson;

@Controller
@RequestMapping("/api/maroma")
public class ClienteController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/agregarCliente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String guardarCliente(@RequestBody Map<String, Object> request) {
		
		logger.debug("request body :" + request);
		ClienteCanonicalResponse clienteCanonicalResponse = null;
		if (request != null) {
			ClienteCanonicalRequest clienteCanonicalRequest = getCanonical(request);
			clienteCanonicalResponse = clienteService.guardarCliente(clienteCanonicalRequest);
		}
		logger.debug("response body : " + clienteCanonicalResponse);
		Gson gson = new Gson();
		String string = gson.toJson(clienteCanonicalResponse);
		return string;
	}

//	@RequestMapping(value = "/eliminarCliente", method = RequestMethod.POST)
//	@ResponseBody
//	public ClienteCanonicalResponse eliminarCliente(@RequestBody ClienteCanonicalRequest request) {
//		logger.debug("request body :" + request);
//
//		ClienteCanonicalResponse response = null;
//		if (request != null) {
//			response = clienteService.eliminarCliente(request);
//		}
//		logger.debug("response body : " + response);
//		return response;
//	}
	
	@RequestMapping(value = "/buscarCliente", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public @ResponseBody String buscarCliente(@RequestBody Map<String, Object> request) {
		logger.debug("request body :" + request);
		ClienteCanonicalResponse clienteCanonicalResponse = null;
		if (request != null) {
			ClienteCanonicalRequest clienteCanonicalRequest = getCanonical(request);
			clienteCanonicalResponse = clienteService.buscarCliente(clienteCanonicalRequest);
		}
		logger.debug("response body : " + clienteCanonicalResponse);
		Gson gson = new Gson();
		String string = gson.toJson(clienteCanonicalResponse);
		return string;
	}
	
	private ClienteCanonicalRequest getCanonical(Map<String, Object> request) {
		ClienteCanonicalRequest clienterequestCanonical = new ClienteCanonicalRequest();
		ClienteDTO clienteDto = new ClienteDTO();
		String tipoCliente = request.get(ConstantesGenericas.TIPO_CLIENTE)==null?null:(String)request.get(ConstantesGenericas.TIPO_CLIENTE);
		String nombre = request.get(ConstantesGenericas.PARAMETER_NOMBRE)==null?null:(String)request.get(ConstantesGenericas.PARAMETER_NOMBRE);
		String apellido = request.get(ConstantesGenericas.PARAMETER_APELLIDO)==null?null:(String)request.get(ConstantesGenericas.PARAMETER_APELLIDO);
		String razonSocial = request.get(ConstantesGenericas.PARAMETER_RAZON_SOCIAL)==null?null:(String)request.get(ConstantesGenericas.PARAMETER_RAZON_SOCIAL);
		String documentoIdentidad = request.get(ConstantesGenericas.PARAMETER_DOCUMENTO_IDENTIDAD)==null?null:(String)request.get(ConstantesGenericas.PARAMETER_DOCUMENTO_IDENTIDAD);
		
		clienteDto.setTipoCliente(tipoCliente);
		clienteDto.setNombre(nombre);
		clienteDto.setApellido(apellido);
		clienteDto.setRazonSocial(razonSocial);
		clienteDto.setNumeroDocumento(documentoIdentidad);
		
		clienterequestCanonical.setClienteDto(clienteDto);
		return clienterequestCanonical;
	}
}
