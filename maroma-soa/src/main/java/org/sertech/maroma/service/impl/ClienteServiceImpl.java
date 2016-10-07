package org.sertech.maroma.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sertech.maroma.canonical.ClienteCanonicalRequest;
import org.sertech.maroma.canonical.ClienteCanonicalResponse;
import org.sertech.maroma.domain.ClienteEntity;
import org.sertech.maroma.dto.ClienteDTO;
import org.sertech.maroma.repository.ClienteRepository;
import org.sertech.maroma.service.ClienteService;
import org.sertech.maroma.utils.ConstantesGenericas;
import org.sertech.maroma.utils.ResponseMensajeContantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import ma.glasnost.orika.MapperFacade;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private MapperFacade mapperFacade;

	@Override
	public ClienteCanonicalResponse guardarCliente(ClienteCanonicalRequest request) {
		ClienteCanonicalResponse response = new ClienteCanonicalResponse();
		Map<String,Object> respuestaMap = new HashMap<>();
		
		ClienteEntity cliente = new ClienteEntity();
		if (esRequestValido(request) == true) {
			cliente = mapperFacade.map(request.getClienteDto(), ClienteEntity.class);
			cliente = clienteRepository.save(cliente);
			
			ClienteDTO clienteDto = mapperFacade.map(cliente, ClienteDTO.class);
			respuestaMap = new HashMap<>();
			respuestaMap.put("cliente", clienteDto);
			respuestaMap.put("message", ResponseMensajeContantes.SERVICE_RESPONSE_OK);
			
			response.setData(respuestaMap);
		} else {
			respuestaMap.put("message", ResponseMensajeContantes.SERVICE_RESPONSE_ERROR);
		}

		return response;
	}

//	@Override
//	public ClienteCanonicalResponse eliminarCliente(ClienteCanonicalRequest request) {
//		ClienteCanonicalResponse response = new ClienteCanonicalResponse();
//
//		ClienteEntity cliente = clienteRepository.findOne(request.getId());
//		cliente.setDeleted("Y");
//		cliente = clienteRepository.save(cliente);
//
//		response.setMensaje(ResponseMensajeContantes.SERVICE_RESPONSE_OK);
//		return response;
//	}

	@Override
	public ClienteCanonicalResponse buscarCliente(ClienteCanonicalRequest request) {
		String documentoIdentidad = null;
		ClienteCanonicalResponse response = new ClienteCanonicalResponse();
		Map<String, Object> respuestaMap = new HashMap<>();
		
		documentoIdentidad = request.getClienteDto().getNumeroDocumento();
		List<ClienteEntity> listaClientes = new ArrayList<>();
		if(documentoIdentidad != null){
			listaClientes = clienteRepository
					.buscarPorDocumentoIdentidad(documentoIdentidad);
		}
		else {
			listaClientes = clienteRepository
					.buscarPorApellido(request.getClienteDto().getApellido());
		}
		if(!CollectionUtils.isEmpty(listaClientes)){
			List<ClienteDTO> clientesDtoList = convertirADto(listaClientes);
			respuestaMap.put(ConstantesGenericas.PARAMETER_CLIENTES, clientesDtoList);
			respuestaMap.put("message", ResponseMensajeContantes.SERVICE_RESPONSE_OK);
		}	
		
		response.setData(respuestaMap);
		return response;
	}
	
	private List<ClienteDTO> convertirADto(List<ClienteEntity> listaClientes) {
		List<ClienteDTO> clienteDtoList = new ArrayList<>();
		for(ClienteEntity cliente : listaClientes){
			ClienteDTO clienteDto = mapperFacade.map(cliente, ClienteDTO.class);
			clienteDtoList.add(clienteDto);
		}
		
		return clienteDtoList;
	}

	/**
	 * 
	 * @param request
	 *            : recibido como input del servicio REST
	 * @return
	 */
	private boolean esRequestValido(ClienteCanonicalRequest request) {
		boolean esValido = true;

		ClienteDTO clienteDto = request.getClienteDto();
		
		if (clienteDto.getTipoCliente() != null
				&& clienteDto.getTipoCliente().equals(ConstantesGenericas.TIPO_CLIENTE_EMPRESA)) {
			if (StringUtils.isEmpty(clienteDto.getRazonSocial())) {
				esValido = false;
			} else if (esRUCValido(clienteDto.getNumeroDocumento()) == false) {
				esValido = false;
			}
		} else if (clienteDto.getTipoCliente() != null
				&& clienteDto.getTipoCliente().equals(ConstantesGenericas.TIPO_CLIENTE_PERSONA)) {
			String nombre = clienteDto.getNombre().trim();
			String apellido = clienteDto.getApellido().trim();

			if (StringUtils.isEmpty(nombre) && StringUtils.isEmpty(apellido)) {
				esValido = false;
			} else if (esDNIValido(clienteDto.getNumeroDocumento()) == false) {
				esValido = false;
			}
		} else {
			esValido = false;
		}
		return esValido;
	}

	/**
	 * 
	 * @param dni
	 *            : Documento Nacional de Indentidad
	 * @return true : si el número es valido false : si el número no es valido
	 */
	private boolean esDNIValido(String dni) {
		boolean esDNIValido = true;
		if (StringUtils.isEmpty(dni)) {
			esDNIValido = true;
		} else {
			dni = dni.trim();
			dni = dni.replaceAll(" ", "");
			if (dni.length() != 8) {
				esDNIValido = false;
			} else {
				if (!dni.matches("\\d{8}")) {
					esDNIValido = false;
				}
			}
		}
		return esDNIValido;
	}

	/**
	 * 
	 * @param ruc
	 *            : Registro Unico de Contribuyente
	 * @return true : si el número es valido false : si el número no es valido
	 */
	private boolean esRUCValido(String ruc) {
		boolean esRUCValido = true;
		if (StringUtils.isEmpty(ruc)) {
			esRUCValido = false;
		} else {
			ruc = ruc.trim();
			ruc = ruc.replaceAll(" ", "");
			if (ruc.length() != 11) {
				esRUCValido = false;
			} else {
				if (!ruc.matches("[1-2]0\\d{9}")) {
					esRUCValido = false;
				}
			}
		}
		return esRUCValido;
	}

}
