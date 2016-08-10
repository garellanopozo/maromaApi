package org.sertech.maroma.service;

import org.sertech.maroma.canonical.ProductoCanonical;
import org.sertech.maroma.domain.ProductoEntity;

public interface ProductoService {
	public ProductoEntity addCategoria(ProductoCanonical product);
	public ProductoEntity deleteCategoria(ProductoCanonical product);
}
