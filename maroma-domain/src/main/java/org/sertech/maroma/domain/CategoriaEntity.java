package org.sertech.maroma.domain;

import javax.persistence.*;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

/**
 * Created by German on 23/07/2016.
 */
@Entity
@Table(name = "categoria")
@AttributeOverrides(value = {
		@AttributeOverride(name = "createdBy", column = @Column(name = "usuario_creacion", nullable = false, updatable = false)),
		@AttributeOverride(name = "createdDate", column = @Column(name = "fecha_creacion", nullable = false, updatable = false)),
		@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ultima_fecha_modificacion", nullable = false)),
		@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ultimo_usuario_modificacion", nullable = false)),
		@AttributeOverride(name = "deleted", column = @Column(name = "borrado", nullable = false))})
@Data
@EntityListeners({ AuditingEntityListener.class })
public class CategoriaEntity extends BaseAuditEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "codigo")
	private String codigo;

	@Column(name = "descripcion")
	private String descripcion;

}
