package org.sertech.maroma.service.impl;

import org.sertech.maroma.canonical.CategoriaCanonical;
import org.sertech.maroma.domain.CategoriaEntity;
import org.sertech.maroma.repository.CategoriaRepository;
import org.sertech.maroma.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public CategoriaEntity addCategoria(CategoriaCanonical categoriaCanonical) {
		CategoriaEntity categoria = new CategoriaEntity();
		categoria.setId(categoriaCanonical.getId());
		categoria.setCodigo(categoriaCanonical.getCodigo());
		categoria.setCodigo(categoriaCanonical.getCodigo());
		categoria = categoriaRepository.save(categoria);
		
		return categoria;
	}

	@Override
	public CategoriaEntity deleteCategoria(CategoriaCanonical categoriaCanonical) {

		CategoriaEntity categoria = new CategoriaEntity();
		categoria.setId(categoriaCanonical.getId());
		categoria = categoriaRepository.findOne(categoria.getId());
		categoria.setDeleted("Y");
		categoria = categoriaRepository.save(categoria);

		return categoria;
	}

}
