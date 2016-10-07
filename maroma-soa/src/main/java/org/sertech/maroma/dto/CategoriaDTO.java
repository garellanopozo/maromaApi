package org.sertech.maroma.dto;

import java.io.Serializable;


import lombok.Data;

@Data
public class CategoriaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long categoriId;
	private String codigo;
	private String descripcion;
}
