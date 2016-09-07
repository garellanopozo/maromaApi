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
    @JoinColumn(name="categoria_id", nullable = false)
    private CategoriaEntity categoriaId;
}
