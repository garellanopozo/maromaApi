package org.sertech.maroma.domain;

import javax.persistence.*;

import lombok.Data;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by German on 23/07/2016.
 */
@Entity
@Table(name = "comprobante")
@Data
@EntityListeners({ AuditingEntityListener.class })
public class ComprobanteEntity extends BaseAuditEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "monto_total")
	private BigDecimal montoTotal;

	@Column(name = "fecha_de_emision", nullable = false)
	private Timestamp fechaDeEmision;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cliente_id")
	private ClienteEntity clienteId;
	
	@Column(name="estado")
	private String estado;
	
}
