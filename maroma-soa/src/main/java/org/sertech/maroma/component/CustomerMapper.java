package org.sertech.maroma.component;

import org.sertech.maroma.domain.CategoriaEntity;
import org.sertech.maroma.domain.ClienteEntity;
import org.sertech.maroma.domain.PrecioProductoEntity;
import org.sertech.maroma.domain.ProductoEntity;
import org.sertech.maroma.dto.CategoriaDTO;
import org.sertech.maroma.dto.ClienteDTO;
import org.sertech.maroma.dto.PrecioProductoDTO;
import org.sertech.maroma.dto.ProductoDTO;
import org.springframework.stereotype.Component;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class CustomerMapper extends ConfigurableMapper{
	protected void configure(MapperFactory factory){
		
		// adding converter
		factory.getConverterFactory().registerConverter(new PassThroughConverter(org.joda.time.DateTime.class));
		// Cliente
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
		
		// Categoria
		factory.classMap(CategoriaEntity.class, CategoriaDTO.class)
		   .field("codigo", "codigo")
		   .field("descripcion", "descripcion")
		   .field("id", "categoriId")
		   .byDefault()
		   .register();
		// Producto
		factory.classMap(ProductoEntity.class, ProductoDTO.class)
		   .field("codigo", "codigo")
		   .field("descripcion", "descripcion")
		   .field("categoriaId", "categoriaId")
		   .field("id", "productoId")
		   .byDefault()
		   .register();
		
		// PrecioProducto
		factory.classMap(PrecioProductoEntity.class, PrecioProductoDTO.class)
		   .field("precioUnitario", "precioUnitario")
		   .field("vigenciaDesde", "vigenciaDesde")
		   .field("vigenciaHasta", "vigenciaHasta")
		   .field("productoId.descripcion", "descripcionProducto")
		   .field("productoId.id", "productoId")
		   .field("id", "precioProductoId")
		   .byDefault()
		   .register();
	}
}
