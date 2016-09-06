package org.sertech.maroma.domain;

import lombok.Data;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Juan on 03/09/2016.
 */
@Entity
@Table(name = "precioproducto")
@Data
@EntityListeners({ AuditingEntityListener.class })
public class PrecioProductoEntity extends BaseAuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "precio_unitario", scale = 8, precision = 2)
	private BigDecimal precioUnitario;
	
	@Column(name = "vigencia_desde", nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters={@Parameter(name="databaseZone", value="jvm")})
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private DateTime vigenciaDesde;
	
	@Column(name = "vigencia_hasta", nullable = true)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters={@Parameter(name="databaseZone", value="jvm")})
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private DateTime vigenciaHasta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id")
	private ProductoEntity productoId;
}
