package org.sertech.maroma;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sertech.maroma.domain.CategoriaEntity;
import org.sertech.maroma.domain.ProductoEntity;
import org.sertech.maroma.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

import java.util.List;

/**
 * Created by garellano on 27/07/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MaromaDomainApplication.class)
public class ProductoTest {

	private Logger logger = Logger.getLogger("MyLog");
    @Autowired
    private ProductoRepository productoRepository;

    @Test
    public void addProducto() throws Exception {
        ProductoEntity prod = new ProductoEntity();
        prod.setCodigo("001");
        prod.setDescripcion("jugo de Naranjas");
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setId(1L);
        prod.setCategoriaId(categoria);
        productoRepository.save(prod);
        assertNotNull(prod.getId());
    }
    
    @Test
    public void updateProducto() throws Exception {
        ProductoEntity prod = productoRepository.findOne(1L);
        prod.setCodigo("00000001");
        prod = productoRepository.save(prod);
        assertNotNull(prod);
    }
    
    @Test
    public void buscarProducto() throws Exception {
        List<ProductoEntity> lista = productoRepository.buscarProducto();
        assertNotNull(lista);
    }
    
    @Test
    public void buscarProductoByDescripcion() throws Exception {
        List<ProductoEntity> lista = productoRepository.buscarProductoByDescription("Entra");
        logger.info(lista.get(0).getCategoriaId().getDescripcion());
        assertNotNull(lista.get(0).getCategoriaId().getDescripcion());
    }
}

