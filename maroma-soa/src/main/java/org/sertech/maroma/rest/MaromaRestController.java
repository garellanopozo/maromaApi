package org.sertech.maroma.rest;

import org.sertech.maroma.domain.ProductoEntity;
import org.sertech.maroma.repository.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by German on 28/07/2016.
 */

@Controller
@RequestMapping("/api/maroma")
public class MaromaRestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductoRepository productoRepository;

    @RequestMapping(value = "/prodList", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductoEntity> getProductoList(){
        System.out.println(productoRepository.findAll());
        return productoRepository.findAll();
    }
}
