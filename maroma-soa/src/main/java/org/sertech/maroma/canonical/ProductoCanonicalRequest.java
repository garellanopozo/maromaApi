package org.sertech.maroma.canonical;

import java.io.Serializable;

import org.sertech.maroma.dto.ProductoDTO;

import lombok.Data;

@Data
public class ProductoCanonicalRequest extends BaseCanonicalRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	private ProductoDTO productoDto;

}
