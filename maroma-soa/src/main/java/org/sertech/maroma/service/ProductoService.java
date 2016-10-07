package org.sertech.maroma.service;

import java.util.Map;

import org.sertech.maroma.canonical.ProductoCanonicalRequest;
import org.sertech.maroma.canonical.ProductoCanonicalResponse;

public interface ProductoService {
	public ProductoCanonicalResponse buscarProductoByDescription(ProductoCanonicalRequest request);
}
