package org.sertech.maroma.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by German on 23/07/2016.
 */
@Entity
@Table(name="producto")
//@AttributeOverrides(value = {
//		@AttributeOverride(name = "createdBy", column = @Column(name = "usuario_creacion", nullable = false)),
//		@AttributeOverride(name = "createdDate", column = @Column(name = "fecha_creacion", nullable = false)),
//		@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ultima_fecha_modificacion", nullable = false)),
//		@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ultimo_usuario_modificacion", nullable = false)),
//		@AttributeOverride(name = "deleted", column = @Column(name = "borrado", nullable = false))})
@Data
@EntityListeners({AuditingEntityListener.class})
public class ProductoEntity extends BaseAuditEntity implements Serializable
{
	private static final long serialVersionUID = 1L;

    @Column(name="codigo")
    private String codigo;

	@Column(name="descripcion")
	private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catid")
    private CategoriaEntity categoriaId;
}
