package org.sertech.maroma;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sertech.maroma.domain.ProductoEntity;
import org.sertech.maroma.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by garellano on 27/07/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MaromaDomainApplication.class)
public class ProductoTest {

    @Autowired
    private ProductoRepository productoRepository;

    @Test
    public void selectitems(){
        System.out.println("Ingreso de items");
    }

    @Test
    public void addProducto() throws Exception {
        ProductoEntity prod = new ProductoEntity();
        prod.setProdCodigo("001");
        prod.setProdDescripcion("jugo de Naranjas");
        productoRepository.save(prod);
        assertNotNull(prod.getId());
        Thread.sleep(2000);
        System.out.println(prod);
    }
}

