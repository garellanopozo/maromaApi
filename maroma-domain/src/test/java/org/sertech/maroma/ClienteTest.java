package org.sertech.maroma;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sertech.maroma.domain.ClienteEntity;
import org.sertech.maroma.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MaromaDomainApplication.class)
public class ClienteTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void findAllTest() throws Exception {
    	List<ClienteEntity> cienteList = clienteRepository.findAll();
    	assertNotNull(cienteList);
    }

    @Test
    public void insertTest() throws Exception {
    	ClienteEntity cliente = new ClienteEntity();
    	cliente.setNombre("Saulo");
    	cliente.setApellido("Gomez");
    	cliente.setNumeroDeIdentIdentificacion("12345678");
    	assertNull(cliente.getId());
    	cliente = clienteRepository.save(cliente);
    	assertNotNull(cliente.getId());
    }
    
    @Test
    public void updateTest() throws Exception {
    	Long clienteId = 1L;
    	ClienteEntity cliente = clienteRepository.findOne(clienteId);
    	cliente.setApellido("Gomez Palacion");
    	clienteRepository.save(cliente);
    	cliente = clienteRepository.findOne(clienteId);
    	assertTrue(cliente.getNombre().equals("Saulo"));
    }
}
