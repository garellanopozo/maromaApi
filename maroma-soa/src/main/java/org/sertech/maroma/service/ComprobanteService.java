package org.sertech.maroma.service;

import org.sertech.maroma.canonical.ComprobanteCanonicalRequest;
import org.sertech.maroma.canonical.ComprobanteCanonicalResponse;

public interface ComprobanteService {
	public ComprobanteCanonicalResponse guardarComprobante(
			ComprobanteCanonicalRequest request);
	public ComprobanteCanonicalResponse eliminarComprobante(
			ComprobanteCanonicalRequest response);
}
