package org.sertech.maroma.canonical;

import java.io.Serializable;

import org.sertech.maroma.dto.PrecioProductoDTO;

import lombok.Data;

@Data
public class PrecioProductoCanonicalRequest extends BaseCanonicalRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	private PrecioProductoDTO precioProductoDto;

}
