package org.sertech.maroma;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sertech.maroma.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by German on 24/07/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MaromaDomainApplication.class)
public class productoTest {

    @Autowired
    private ProductoRepository productoRepository;


    /*@Test
    @Sql(statements ={"insert into Producto_Entity (prodId,prodCod,prodName) values (1,'001','Jugo de Naranja')"})
    public void addProducto() throws Exception {
        for(ProductoEntity producto : productoRepository.findAll()) {
            System.out.println(producto);
        }
    }*/

    @Test
    public void selectitems(){
        System.out.println("Ingreso de items");
    }

}
