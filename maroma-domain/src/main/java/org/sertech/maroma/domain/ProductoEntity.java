package org.sertech.maroma.domain;

import lombok.Data;

import org.joda.time.DateTime;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by German on 23/07/2016.
 */
@Entity
@Data
@EntityListeners({AuditingEntityListener.class})
@Table(name="producto")
public class ProductoEntity extends AbstractAuditable<ProductoEntity, Long> 
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    private Long id;

    @Column(name="codigo")
    private String codigo;

    @Column(name="descripcion")
    private String descripcion;
    
    @Column(name = "habilitado")
    private String habilitado;
    
    @Column(name = "creadopor")
    private Long creadoPor;
    
    @Column(name = "fechacreado")
    private DateTime fechaCreado;
    
    @Column(name = "actualizadopor")
    private Long actualizadoPor;
    
    @Column(name = "fechaactualizado")
    private DateTime fechaActualizado;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catid")
    private CategoriaEntity categoriaId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}

	public Long getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(Long creadoPor) {
		this.creadoPor = creadoPor;
	}

	public DateTime getFechaCreado() {
		return fechaCreado;
	}

	public void setFechaCreado(DateTime fechaCreado) {
		this.fechaCreado = fechaCreado;
	}

	public Long getActualizadoPor() {
		return actualizadoPor;
	}

	public void setActualizadoPor(Long actualizadoPor) {
		this.actualizadoPor = actualizadoPor;
	}

	public DateTime getFechaActualizado() {
		return fechaActualizado;
	}

	public void setFechaActualizado(DateTime fechaActualizado) {
		this.fechaActualizado = fechaActualizado;
	}

	public CategoriaEntity getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(CategoriaEntity categoriaId) {
		this.categoriaId = categoriaId;
	}

	@Override
	public String toString() {
		return "ProductoEntity [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", habilitado="
				+ habilitado + ", creadoPor=" + creadoPor + ", fechaCreado=" + fechaCreado + ", actualizadoPor="
				+ actualizadoPor + ", fechaActualizado=" + fechaActualizado + ", categoriaId=" + categoriaId + "]";
	}
    
}
