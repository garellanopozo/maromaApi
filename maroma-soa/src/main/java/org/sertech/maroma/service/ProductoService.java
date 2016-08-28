package org.sertech.maroma.service;

import java.util.List;

import org.sertech.maroma.canonical.ProductoCanonicalRequest;
import org.sertech.maroma.canonical.ProductoCanonicalResponse;

public interface ProductoService {
	public ProductoCanonicalResponse agregarProducto(ProductoCanonicalRequest product);
	public ProductoCanonicalResponse eliminarProducto(ProductoCanonicalRequest product);
	public List<ProductoCanonicalResponse> buscarProducto();
}
