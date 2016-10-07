package org.sertech.maroma.rest;

import org.sertech.maroma.canonical.BaseCanonicalResponse;

import com.google.gson.Gson;

public abstract class BaseController {
	
	protected Gson gson = new Gson();
	
	protected String convertirJson(BaseCanonicalResponse response){
		String strResponse = gson.toJson(response);
		return strResponse;
	}
}
