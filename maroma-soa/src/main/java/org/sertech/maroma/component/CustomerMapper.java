package org.sertech.maroma.component;

import org.sertech.maroma.domain.CategoriaEntity;
import org.sertech.maroma.domain.ClienteEntity;
import org.sertech.maroma.domain.ProductoEntity;
import org.sertech.maroma.dto.CategoriaDTO;
import org.sertech.maroma.dto.ClienteDTO;
import org.sertech.maroma.dto.ProductoDTO;
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
		   .field("numeroDeIdentIdentificacion", "numeroDocumento")
		   .field("estado", "estado")
		   .field("tipoCliente", "tipoCliente")
		   .field("id", "clienteId")
		   .byDefault()
		   .register();
		
		factory.classMap(CategoriaEntity.class, CategoriaDTO.class)
		   .field("codigo", "codigo")
		   .field("descripcion", "descripcion")
		   .field("id", "categoriId")
		   .byDefault()
		   .register();
		
		factory.classMap(ProductoEntity.class, ProductoDTO.class)
		   .field("codigo", "codigo")
		   .field("descripcion", "descripcion")
		   .field("categoriaId", "categoriaId")
		   .field("id", "productoId")
		   .byDefault()
		   .register();
	}
}
