package org.sertech.maroma.canonical;

import java.io.Serializable;

import lombok.Data;

@Data
public class CategoriaCanonicalResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String codigo;
	private String descripcion;

}
