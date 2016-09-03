package org.sertech.maroma.domain;

import javax.persistence.*;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

/**
 * Created by jzapata on 27/08/2016.
 */
@Entity
@Table(name = "cliente")
@Data
@EntityListeners({ AuditingEntityListener.class })
public class ClienteEntity extends BaseAuditEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "razon_social")
	private String razonSocial;
	
	@Column(name = "numero_de_identificacion")
	private String numeroDeIdentIdentificacion;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "tipo_cliente")
	private String tipoCliente;
}
