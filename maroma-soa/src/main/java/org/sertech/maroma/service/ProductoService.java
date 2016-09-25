package org.sertech.maroma.service;

import java.util.List;
import java.util.Map;

import org.sertech.maroma.canonical.ProductoCanonicalRequest;
import org.sertech.maroma.canonical.ProductoCanonicalResponse;

public interface ProductoService {
	public ProductoCanonicalResponse agregarProducto(ProductoCanonicalRequest request);
	public ProductoCanonicalResponse eliminarProducto(ProductoCanonicalRequest response);
	public List<ProductoCanonicalResponse> buscarProducto();
	public ProductoCanonicalResponse buscarProductoByDescription(Map<String, String> map);
}
