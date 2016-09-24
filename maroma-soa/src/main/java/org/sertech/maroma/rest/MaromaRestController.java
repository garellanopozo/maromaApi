package org.sertech.maroma.rest;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.sertech.maroma.canonical.CategoriaCanonicalRequest;
import org.sertech.maroma.canonical.CategoriaCanonicalResponse;
import org.sertech.maroma.canonical.ClienteCanonicalRequest;
import org.sertech.maroma.canonical.ClienteCanonicalResponse;
import org.sertech.maroma.canonical.ComprobanteCanonicalRequest;
import org.sertech.maroma.canonical.ComprobanteCanonicalResponse;
import org.sertech.maroma.canonical.ProductoCanonicalRequest;
import org.sertech.maroma.canonical.ProductoCanonicalResponse;
import org.sertech.maroma.service.CategoriaService;
import org.sertech.maroma.service.ClienteService;
import org.sertech.maroma.service.ComprobanteService;
import org.sertech.maroma.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by German on 28/07/2016.
 */

@Controller
@RequestMapping("/api/maroma")
public class MaromaRestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private ComprobanteService comprobanteService;

    /*
     * Categoria Service
     */
    @RequestMapping(value = "/guardarCategoria", method = RequestMethod.POST)
    @ResponseBody
    public CategoriaCanonicalResponse guardarCategoria(@RequestBody CategoriaCanonicalRequest request){
    	logger.debug("request body :" + request);
    	CategoriaCanonicalResponse response = null;
    	if ( request != null ){
    		response = categoriaService.guardarCategoria(request);
    	}
    	logger.debug("response body : " + response);
        return response;
    }
    
    @RequestMapping(value = "/eliminarCategoria", method = RequestMethod.POST)
    @ResponseBody
    public CategoriaCanonicalResponse eliminarCategoria(@RequestBody CategoriaCanonicalRequest categoriaCanonical){
    	logger.debug("request body :" + categoriaCanonical);
    	CategoriaCanonicalResponse response = null;
    	if ( categoriaCanonical.getId() != null ){
    		response = categoriaService.eliminarCategoria(categoriaCanonical);
    	}
    	logger.debug("response body : " + response);
        return response;
    }
    
    /*
     * Producto Services
     */
    @RequestMapping(value = "/guardarProducto", method = RequestMethod.POST)
    @ResponseBody
    public ProductoCanonicalResponse guardarProduct(@RequestBody ProductoCanonicalRequest request){
    	logger.debug("request body :" + request);
    	
    	ProductoCanonicalResponse response = null;
    	if ( request != null ){
    		response = productoService.agregarProducto(request);
    	}
    	logger.debug("response body : " + response);
        return response;
    }
    
    @RequestMapping(value = "/eliminarProducto", method = RequestMethod.POST)
    @ResponseBody
    public ProductoCanonicalResponse eliminarProducto(@RequestBody ProductoCanonicalRequest request){
    	logger.debug("request body :" + request);
    	
    	ProductoCanonicalResponse response = null;
    	if ( request.getId() != null ){
    		response = productoService.eliminarProducto(request);
    	}
    	logger.debug("response body : " + response);
        return response;
    }
    
    @RequestMapping(value = "/buscarProducto", method = RequestMethod.POST)
    @ResponseBody
    public List<ProductoCanonicalResponse> findProducto(){
    	
    	List<ProductoCanonicalResponse> response = null;    	
    	response = productoService.buscarProducto();  
    	logger.debug("response body : " + response);
        return response;
    }
    
    /*
     * Cliente Services
     */
    @RequestMapping(value = "/guardarCliente", method = RequestMethod.POST)
    @ResponseBody
    public ClienteCanonicalResponse guardarCliente(@RequestBody ClienteCanonicalRequest request){
    	logger.debug("request body :" + request);
    	
    	ClienteCanonicalResponse response = null;
    	if ( request != null ){
    		response = clienteService.guardarCliente(request);
    	}
    	logger.debug("response body : " + response);
        return response;
    }
    
    @RequestMapping(value = "/eliminarCliente", method = RequestMethod.POST)
    @ResponseBody
    public ClienteCanonicalResponse eliminarCliente(@RequestBody ClienteCanonicalRequest request){
    	logger.debug("request body :" + request);
    	
    	ClienteCanonicalResponse response = null;
    	if ( request != null ){
    		response = clienteService.eliminarCliente(request);
    	}
    	logger.debug("response body : " + response);
        return response;
    }
    
    @RequestMapping(value = "/buscarCliente", method = RequestMethod.POST)
    public ClienteCanonicalResponse buscarCliente(@RequestBody Map<String, Object> request){
    	logger.debug("request body :" + request);
    	ClienteCanonicalResponse response = null;
    	if ( request != null ){
    		//response = clienteService.buscarCliente(request);
    	}
    	logger.debug("response body : " + response);
        return response;
    }

    @RequestMapping(value = "/buscarCliente01", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String buscarCliente01() {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("data","hola");
        Gson gson = new Gson();
        String json = gson.toJson(map);
        return json;
    }

    /*@RequestMapping(value = "/buscarCliente02", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addDevice(@RequestBody Map<String, Object> request) {
        return storeService.addDevice(request);
    }
*/
    @RequestMapping(value = "/buscarCliente02", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String buscarCliente02(@RequestBody Map<String, Object> request) {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("data",request.get("dni"));
        Gson gson = new Gson();
        String json = gson.toJson(map);
        return json;
    }

    /*@RequestMapping(value = "/deleteDevice", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String,Object> deleteDevice(@RequestParam Map<String, Object> request) {
        return storeService.deleteDevice(request);
    }

    @RequestMapping(value = "/updateDrawer", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  Map<String,Object>  updateDrawer(@RequestBody Map<String, Object> request) {
        Map<String,Object> response = null;
        try{
            response = storeService.updateDrawer(request);

        }catch(Exception e){
            response = new HashMap<String, Object>();
            logger.error(e.getMessage());
        }
        return response;
    }*/



    
    /*
     * Comprobante Services
     */
    @RequestMapping(value = "/guardarComprobante", method = RequestMethod.POST)
    @ResponseBody
    public ComprobanteCanonicalResponse guardarComprobante(@RequestBody ComprobanteCanonicalRequest request){
    	logger.debug("request body :" + request);
    	ComprobanteCanonicalResponse response = null;
    	if ( request != null ){
    		response = comprobanteService.guardarComprobante(request);
    	}
    	logger.debug("response body : " + response);
        return response;
    }
}
