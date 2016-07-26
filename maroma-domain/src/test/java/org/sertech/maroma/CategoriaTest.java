package org.sertech.maroma;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sertech.maroma.domain.CategoriaEntity;
import org.sertech.maroma.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MaromaDomainApplication.class)
public class CategoriaTest {

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Test
    public void findAllTest() throws Exception {
        for(CategoriaEntity producto : categoriaRepository.findAll()) {
            System.out.println(producto);
        }
    }
    
    @Test
    public void insertTest() throws Exception {
    	CategoriaEntity categoria = new CategoriaEntity();
    	categoria.setCodigo("Menu");
    	categoria.setDescripcion("Menu");
    	assertNull(categoria.getId());
    	categoria = categoriaRepository.save(categoria);
    	assertNotNull(categoria.getId());
    	Thread.sleep(2000);
    	categoria.setDescripcion("Menu Menu");
    	categoria = categoriaRepository.save(categoria);
    	System.out.println(categoria);
    }

    @Test
    public void selectitems(){
        System.out.println("Ingreso de items");
    }

}
