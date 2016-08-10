package org.sertech.maroma.service;

import org.sertech.maroma.canonical.CategoriaCanonical;
import org.sertech.maroma.domain.CategoriaEntity;

public interface CategoriaService {
	public CategoriaEntity addCategoria(CategoriaCanonical categoriaCanonical);
	public CategoriaEntity deleteCategoria(CategoriaCanonical categoriaCanonical);
}
