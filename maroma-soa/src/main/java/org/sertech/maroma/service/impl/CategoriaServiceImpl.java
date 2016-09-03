package org.sertech.maroma.service.impl;

import org.sertech.maroma.canonical.CategoriaCanonicalRequest;
import org.sertech.maroma.canonical.CategoriaCanonicalResponse;
import org.sertech.maroma.domain.CategoriaEntity;
import org.sertech.maroma.repository.CategoriaRepository;
import org.sertech.maroma.service.CategoriaService;
import org.sertech.maroma.utils.ResponseMensajeContantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public CategoriaCanonicalResponse guardarCategoria(CategoriaCanonicalRequest request) {
		
		CategoriaCanonicalResponse response = new CategoriaCanonicalResponse();
		
		CategoriaEntity categoria = new CategoriaEntity();
		categoria.setId(request.getId());
		categoria.setCodigo(request.getCodigo());
		categoria.setDescripcion(request.getDescripcion());
		categoria = categoriaRepository.save(categoria);
		
		response.setId(categoria.getId());
		response.setCodigo(categoria.getCodigo());
		response.setDescripcion(categoria.getDescripcion());
		response.setMensaje(ResponseMensajeContantes.SERVICE_RESPONSE_ERROR);
		
		return response;
	}

	@Override
	public CategoriaCanonicalResponse eliminarCategoria(CategoriaCanonicalRequest categoriaCanonical) {

		CategoriaCanonicalResponse response = new CategoriaCanonicalResponse();
		
		CategoriaEntity categoria = new CategoriaEntity();
		categoria.setId(categoriaCanonical.getId());
		categoria = categoriaRepository.findOne(categoria.getId());
		categoria.setDeleted("Y");
		categoria = categoriaRepository.save(categoria);

		response.setId(categoria.getId());
		response.setCodigo(categoria.getCodigo());
		response.setDescripcion(categoria.getDescripcion());
		response.setMensaje(ResponseMensajeContantes.SERVICE_RESPONSE_OK);
		return response;
	}

}
