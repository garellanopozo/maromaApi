package org.sertech.maroma.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long productoId;
    private String codigo;
	private String descripcion;
    private CategoriaDTO categoriaId;
}
