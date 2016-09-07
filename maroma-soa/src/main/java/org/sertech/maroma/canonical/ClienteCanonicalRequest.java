package org.sertech.maroma.canonical;

import java.io.Serializable;

import lombok.Data;

@Data
public class ClienteCanonicalRequest extends BaseCanonicalRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private String apellido;
	private String razonSocial;
	private String numeroDeIdentIdentificacion;
	private String estado;
	private String tipoCliente;
	
}
