package org.sertech.maroma.canonical;

import java.util.Map;

import lombok.Data;

@Data
public class BaseCanonicalResponse {
	protected String mensaje;
	protected Map<String, Object> respuesta;
}
