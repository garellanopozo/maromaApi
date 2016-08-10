package org.sertech.maroma.service.impl;

import org.sertech.maroma.canonical.ProductoCanonical;
import org.sertech.maroma.domain.CategoriaEntity;
import org.sertech.maroma.domain.ProductoEntity;
import org.sertech.maroma.repository.ProductoRepository;
import org.sertech.maroma.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductoService {

	@Autowired
    private ProductoRepository productoRepository;
	
	@Override
	public ProductoEntity addCategoria(ProductoCanonical productoCanonical) {
		
		ProductoEntity producto = new ProductoEntity();
		producto.setId(productoCanonical.getId());
		producto.setCodigo(productoCanonical.getCodigo());
		producto.setDescripcion(productoCanonical.getDescripcion());
		CategoriaEntity categoria = new CategoriaEntity();
		categoria.setId(productoCanonical.getCategoriaId());
		producto = productoRepository.save(producto);
		return producto;
	}

	@Override
	public ProductoEntity deleteCategoria(ProductoCanonical productoCanonical) {

		ProductoEntity producto = new ProductoEntity();
		producto = productoRepository.findOne(productoCanonical.getId());
		producto.setDeleted("Y");
		producto = productoRepository.save(producto);
		
		return producto;
	}

}
