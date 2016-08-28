package org.sertech.maroma;

import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Autowired
    private ProductoRepository productoRepository;

    @Test
    public void addProducto() throws Exception {
        ProductoEntity prod = new ProductoEntity();
        prod.setCodigo("001");
        prod.setDescripcion("jugo de Naranjas");
        prod.setCategoriaId(1);
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
}

