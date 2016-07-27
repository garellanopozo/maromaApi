package org.sertech.maroma.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

/**
 * Created by German on 23/07/2016.
 */
@Entity
@Table(name = "categoria")
@Data
@EntityListeners({ AuditingEntityListener.class })
public class CategoriaEntity extends BaseAuditEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "codigo")
	private String codigo;

	@Column(name = "descripcion")
	private String descripcion;

}
