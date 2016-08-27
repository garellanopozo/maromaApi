package org.sertech.maroma;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
    	List<CategoriaEntity> producto = categoriaRepository.findAll();
    	assertNotNull(producto);
    }

    @Test
    public void insertTest() throws Exception {
    	CategoriaEntity categoria = new CategoriaEntity();
    	categoria.setCodigo("00000001");
    	categoria.setDescripcion("Menu");
    	assertNull(categoria.getId());
    	categoria = categoriaRepository.save(categoria);
    	assertNotNull(categoria.getId());
    }
    
    @Test
    public void updateTest() throws Exception {
    	Long productId = 5L;
    	CategoriaEntity categoria = categoriaRepository.findOne(productId);
    	categoria.setCodigo("00000001");
    	categoria.setDescripcion("Menu");
    	categoriaRepository.save(categoria);
    	categoria = categoriaRepository.findOne(productId);
    	assertTrue(categoria.getCodigo().equals("00000001"));
    }
}
