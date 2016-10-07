package org.sertech.maroma.service;

import org.sertech.maroma.canonical.PrecioProductoCanonicalRequest;
import org.sertech.maroma.canonical.PrecioProductoCanonicalResponse;

public interface PrecioProductoService {
	public PrecioProductoCanonicalResponse buscarProductoByDescription(PrecioProductoCanonicalRequest request);
}
