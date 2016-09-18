package org.sertech.maroma.domain;

import javax.persistence.*;

import lombok.Data;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by German on 23/07/2016.
 */
@Entity
@Table(name = "detallecomprobante")
@Data
@EntityListeners({ AuditingEntityListener.class })
public class DetalleComprobanteEntity extends BaseAuditEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "monto")
	private BigDecimal monto;

	@Column(name = "cantidad")
	private Integer cantidad;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="precio_producto_id")
	private PrecioProductoEntity precioProductoId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="comprobante_id")
	private ComprobanteEntity comprobanteId;
	
}
