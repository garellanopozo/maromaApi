package org.sertech.maroma.service;

import org.sertech.maroma.canonical.CategoriaCanonicalRequest;
import org.sertech.maroma.canonical.CategoriaCanonicalResponse;

public interface CategoriaService {
	public CategoriaCanonicalResponse addCategoria(CategoriaCanonicalRequest categoriaCanonical);
	public CategoriaCanonicalResponse deleteCategoria(CategoriaCanonicalRequest categoriaCanonical);
}
