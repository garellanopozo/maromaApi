package org.sertech.maroma;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sertech.maroma.domain.ClienteEntity;
import org.sertech.maroma.domain.ComprobanteEntity;
import org.sertech.maroma.repository.ComprobanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MaromaDomainApplication.class)
public class ComprobanteTest {

    @Autowired
    private ComprobanteRepository comprobanteRepository;

    @Test
    public void agregarComprobanteTest (){
    	ComprobanteEntity comprobante = new ComprobanteEntity();
    	comprobante.setMontoTotal(BigDecimal.TEN);
    	comprobante.setEstado("ACTIVO");
    	Date instant = new Date();
    	Timestamp fechaEmision = new Timestamp(instant.getTime());
    	comprobante.setFechaDeEmision(fechaEmision);
    	ClienteEntity cliente = new ClienteEntity();
    	cliente.setId(1L);
    	comprobante.setClienteId(cliente);
    	comprobante = comprobanteRepository.save(comprobante);
    	
    	assertNotNull(comprobante.getId());
    }
    
    @Test
    public void buscarPorClienteTest(){
    	List<ComprobanteEntity> lista = comprobanteRepository.buscarPorCliente(1L);
    	assertNotNull(lista);
    }
}

