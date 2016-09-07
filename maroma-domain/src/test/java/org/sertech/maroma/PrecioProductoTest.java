package org.sertech.maroma;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sertech.maroma.domain.PrecioProductoEntity;
import org.sertech.maroma.domain.ProductoEntity;
import org.sertech.maroma.repository.PrecioProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MaromaDomainApplication.class)
public class PrecioProductoTest {

    @Autowired
    private PrecioProductoRepository precioProductoRepository;

    @Test
    public void agregarPrecioProducto() throws Exception {
        PrecioProductoEntity precioprod = new PrecioProductoEntity();
        precioprod.setPrecioUnitario(BigDecimal.TEN);
        precioprod.setVigenciaDesde(new DateTime(Calendar.getInstance().getTimeInMillis()));
        ProductoEntity producto = new ProductoEntity();
        producto.setId(1L);
        precioprod.setProductoId(producto);
        precioprod = precioProductoRepository.save(precioprod);
        assertNotNull(precioprod.getId());
    }
}

