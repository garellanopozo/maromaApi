package org.sertech.maroma.service;

import org.sertech.maroma.canonical.CategoriaCanonicalRequest;
import org.sertech.maroma.canonical.CategoriaCanonicalResponse;

public interface CategoriaService {
	public CategoriaCanonicalResponse guardarCategoria(CategoriaCanonicalRequest request);
	public CategoriaCanonicalResponse eliminarCategoria(CategoriaCanonicalRequest response);
}
