package org.sertech.maroma.rest;

import org.sertech.maroma.canonical.CategoriaCanonical;
import org.sertech.maroma.canonical.ProductoCanonical;
import org.sertech.maroma.domain.CategoriaEntity;
import org.sertech.maroma.domain.ProductoEntity;
import org.sertech.maroma.service.CategoriaService;
import org.sertech.maroma.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/maroma")
public class MaromaRestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;

    /*
     * Categoria Service
     */
    @RequestMapping(value = "/saveCategoria", method = RequestMethod.POST)
    @ResponseBody
    public CategoriaEntity saveCategoria(@RequestBody CategoriaCanonical categoriaCanonical){
    	logger.debug("request body :" + categoriaCanonical);
    	CategoriaEntity categoria = null;
    	if ( categoriaCanonical != null ){
    		categoria = categoriaService.addCategoria(categoriaCanonical);
    	}
    	logger.debug("response body : " + categoria);
        return categoria;
    }
    
    @RequestMapping(value = "/deleteCategoria", method = RequestMethod.POST)
    @ResponseBody
    public CategoriaEntity deleteCategoria(@RequestBody CategoriaCanonical categoriaCanonical){
    	logger.debug("request body :" + categoriaCanonical);
    	CategoriaEntity categoria = null;
    	if ( categoriaCanonical.getId() != null ){
    		categoria = categoriaService.deleteCategoria(categoriaCanonical);
    	}
    	logger.debug("response body : " + categoria);
        return categoria;
    }
    
    /*
     * Producto Services
     */
    @RequestMapping(value = "/saveCategoria", method = RequestMethod.POST)
    @ResponseBody
    public ProductoEntity saveProduct(@RequestBody ProductoCanonical productCanonical){
    	logger.debug("request body :" + productCanonical);
    	
    	ProductoEntity producto = null;
    	if ( productCanonical != null ){
    		producto = productoService.addCategoria(productCanonical);
    	}
    	logger.debug("response body : " + producto);
        return producto;
    }
    
    @RequestMapping(value = "/deleteCategoria", method = RequestMethod.POST)
    @ResponseBody
    public ProductoEntity deleteProducto(@RequestBody ProductoCanonical productCanonical){
    	logger.debug("request body :" + productCanonical);
    	
    	ProductoEntity producto = null;
    	if ( productCanonical.getId() != null ){
    		producto = productoService.deleteCategoria(productCanonical);
    	}
    	logger.debug("response body : " + producto);
        return producto;
    }
}
