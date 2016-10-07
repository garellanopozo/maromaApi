package org.sertech.maroma.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import org.joda.time.DateTime;

import lombok.Data;

@Data
public class PrecioProductoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long precioProductoId;
	private BigDecimal precioUnitario;
	private DateTime vigenciaDesde;
	private DateTime vigenciaHasta;
	private String descripcionProducto;
	private Long productoId;
}
