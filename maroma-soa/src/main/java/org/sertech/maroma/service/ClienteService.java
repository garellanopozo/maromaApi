package org.sertech.maroma.service;

import org.sertech.maroma.canonical.ClienteCanonicalRequest;
import org.sertech.maroma.canonical.ClienteCanonicalResponse;

public interface ClienteService {
	public ClienteCanonicalResponse guardarCliente(ClienteCanonicalRequest request);
//	public ClienteCanonicalResponse eliminarCliente(ClienteCanonicalRequest request);
	public ClienteCanonicalResponse buscarCliente(ClienteCanonicalRequest request);
}
