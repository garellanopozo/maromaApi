package org.sertech.maroma.service.impl;

import org.sertech.maroma.canonical.ClienteCanonicalRequest;
import org.sertech.maroma.canonical.ClienteCanonicalResponse;
import org.sertech.maroma.domain.ClienteEntity;
import org.sertech.maroma.repository.ClienteRepository;
import org.sertech.maroma.service.ClienteService;
import org.sertech.maroma.utils.ConstantesGenericas;
import org.sertech.maroma.utils.ResponseMensajeContantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public ClienteCanonicalResponse guardarCliente(ClienteCanonicalRequest request) {
		ClienteCanonicalResponse response = new ClienteCanonicalResponse();

		ClienteEntity cliente = new ClienteEntity();
		if (esRequestValido(request) == true) {
			cliente = buildCliente(request);
			cliente = clienteRepository.save(cliente);

			response.setNombre(cliente.getNombre());
			response.setApellido(cliente.getApellido());
			response.setRazonSocial(cliente.getRazonSocial());
			response.setNumeroDeIdentIdentificacion(cliente.getNumeroDeIdentIdentificacion());
			response.setMensaje(ResponseMensajeContantes.SERVICE_RESPONSE_OK);
		} else {
			response.setMensaje(ResponseMensajeContantes.SERVICE_RESPONSE_ERROR);
		}

		return response;
	}

	@Override
	public ClienteCanonicalResponse eliminarCliente(ClienteCanonicalRequest request) {
		ClienteCanonicalResponse response = new ClienteCanonicalResponse();

		ClienteEntity cliente = clienteRepository.findOne(request.getId());
		cliente.setDeleted("Y");
		cliente = clienteRepository.save(cliente);

		response.setMensaje(ResponseMensajeContantes.SERVICE_RESPONSE_OK);
		return response;
	}

	/**
	 * Construye Entity desde el request
	 * 
	 * @param request
	 * @return
	 */
	private ClienteEntity buildCliente(ClienteCanonicalRequest request) {
		ClienteEntity cliente = new ClienteEntity();

		if (request.getTipoCliente() != null
				&& request.getTipoCliente().equals(ConstantesGenericas.TIPO_CLIENTE_PERSONA)) {
			cliente.setNombre(request.getNombre());
			cliente.setApellido(request.getApellido());
			cliente.setTipoCliente(ConstantesGenericas.TIPO_CLIENTE_PERSONA);
		} else {
			cliente.setRazonSocial(request.getRazonSocial());
			cliente.setTipoCliente(ConstantesGenericas.TIPO_CLIENTE_EMPRESA);
		}
		cliente.setNumeroDeIdentIdentificacion(request.getNumeroDeIdentIdentificacion());
		cliente.setEstado(ConstantesGenericas.ACTIVO);

		return cliente;
	}

	/**
	 * 
	 * @param request
	 *            : recibido como input del servicio REST
	 * @return
	 */
	private boolean esRequestValido(ClienteCanonicalRequest request) {
		boolean esValido = true;

		if (request.getTipoCliente() != null
				&& request.getTipoCliente().equals(ConstantesGenericas.TIPO_CLIENTE_EMPRESA)) {
			if (StringUtils.isEmpty(request.getRazonSocial())) {
				esValido = false;
			} else if (esRUCValido(request.getNumeroDeIdentIdentificacion()) == false) {
				esValido = false;
			}
		} else if (request.getTipoCliente() != null
				&& request.getTipoCliente().equals(ConstantesGenericas.TIPO_CLIENTE_PERSONA)) {
			String nombre = request.getNombre().trim();
			String apellido = request.getApellido().trim();

			if (StringUtils.isEmpty(nombre) && StringUtils.isEmpty(apellido)) {
				esValido = false;
			} else if (esDNIValido(request.getNumeroDeIdentIdentificacion()) == false) {
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
