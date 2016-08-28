package org.sertech.maroma.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.sertech.maroma.canonical.ProductoCanonicalRequest;
import org.sertech.maroma.canonical.ProductoCanonicalResponse;
import org.sertech.maroma.domain.CategoriaEntity;
import org.sertech.maroma.domain.ProductoEntity;
import org.sertech.maroma.repository.ProductoRepository;
import org.sertech.maroma.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class ProductServiceImpl implements ProductoService {

	@Autowired
    private ProductoRepository productoRepository;
	
	@Override
	public ProductoCanonicalResponse agregarProducto(ProductoCanonicalRequest productoCanonical) {
		
		ProductoCanonicalResponse response = new ProductoCanonicalResponse();
		
		ProductoEntity producto = new ProductoEntity();
		producto.setId(productoCanonical.getId());
		producto.setCodigo(productoCanonical.getCodigo());
		producto.setDescripcion(productoCanonical.getDescripcion());
		CategoriaEntity categoria = new CategoriaEntity();
		categoria.setId(productoCanonical.getCategoriaId());
		producto = productoRepository.save(producto);
		
		response.setId(producto.getId());
		
		return response;
	}

	@Override
	public ProductoCanonicalResponse eliminarProducto(ProductoCanonicalRequest productoCanonical) {

		ProductoCanonicalResponse response = new ProductoCanonicalResponse();
		
		ProductoEntity producto = new ProductoEntity();
		producto = productoRepository.findOne(productoCanonical.getId());
		producto.setDeleted("Y");
		producto = productoRepository.save(producto);
		
		response.setId(producto.getId());
		
		return response;
	}

	@Override
	public List<ProductoCanonicalResponse> buscarProducto() {
		
		List<ProductoCanonicalResponse> response = new ArrayList<ProductoCanonicalResponse>();
		List<ProductoEntity> listaProductos = productoRepository.buscarProducto();
		if(!CollectionUtils.isEmpty(listaProductos)){
			for(ProductoEntity producto : listaProductos){
				ProductoCanonicalResponse productoCanonical = new ProductoCanonicalResponse();
				productoCanonical.setId(producto.getId());
				productoCanonical.setCodigo(producto.getCodigo());
				productoCanonical.setDescripcion(producto.getDescripcion());
				response.add(productoCanonical);
			}
		}
		return response;
	}

}
