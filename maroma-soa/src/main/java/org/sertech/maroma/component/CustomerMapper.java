package org.sertech.maroma.component;

import org.sertech.maroma.domain.ClienteEntity;
import org.sertech.maroma.dto.ClienteDTO;
import org.springframework.stereotype.Component;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class CustomerMapper extends ConfigurableMapper{
	protected void configure(MapperFactory factory){
		factory.classMap(ClienteEntity.class, ClienteDTO.class)
		   .field("nombre", "nombre")
		   .field("apellido", "apellido")
		   .field("razonSocial", "razonSocial")
		   .field("numeroDeIdentIdentificacion", "numeroDeIdentIdentificacion")
		   .field("estado", "estado")
		   .field("tipoCliente", "tipoCliente")
		   .field("id", "id")
		   .byDefault()
		   .register();
	}
}
