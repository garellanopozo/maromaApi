package org.sertech.maroma.service.impl;

import org.sertech.maroma.canonical.ClienteCanonicalRequest;
import org.sertech.maroma.canonical.ClienteCanonicalResponse;
import org.sertech.maroma.domain.ClienteEntity;
import org.sertech.maroma.repository.ClienteRepository;
import org.sertech.maroma.service.ClienteService;
import org.sertech.maroma.utils.ResponseMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
    private ClienteRepository clienteRepository;
	
	@Override
	public ClienteCanonicalResponse guardarCliente(ClienteCanonicalRequest request) {
		ClienteCanonicalResponse response = new ClienteCanonicalResponse();
		
		ClienteEntity cliente = new ClienteEntity();
		if(esRequestValido(request)){
			cliente.setNombre(cliente.getNombre());
			cliente.setApellido(cliente.getApellido());
			cliente.setRazonSocial(cliente.getRazonSocial());
			cliente.setNumeroDeIdentIdentificacion(cliente.getNumeroDeIdentIdentificacion());
			cliente = clienteRepository.save(cliente);
			
			response .setNombre(cliente.getNombre());
			response .setApellido(cliente.getApellido());
			response .setRazonSocial(cliente.getRazonSocial());
			response .setNumeroDeIdentIdentificacion(cliente.getNumeroDeIdentIdentificacion());
		}
		else 
		{
			response.setMensaje(ResponseMensaje.SERVICE_RESPONSE_ERROR);
		}
		
		return response;
	}
	
	@Override
	public ClienteCanonicalResponse eliminarCliente(ClienteCanonicalRequest request) {
		ClienteCanonicalResponse response = new ClienteCanonicalResponse();
		
		ClienteEntity cliente = clienteRepository.findOne(request.getId());
		cliente.setDeleted("Y");
		cliente = clienteRepository.save(cliente);
		
		response.setMensaje(ResponseMensaje.SERVICE_RESPONSE_OK);
		return response;
	}
	
	private boolean esRequestValido(ClienteCanonicalRequest request) {
		return true;
	}
}
