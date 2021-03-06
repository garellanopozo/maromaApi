package org.sertech.maroma.rest;

import org.sertech.maroma.canonical.ComprobanteCanonicalRequest;
import org.sertech.maroma.canonical.ComprobanteCanonicalResponse;
import org.sertech.maroma.service.ComprobanteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by German on 28/07/2016.
 */

@Controller
@RequestMapping("/api/maroma")
public class MaromaRestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

}
