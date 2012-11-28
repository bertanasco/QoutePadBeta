package org.mobiletao.qoutepad.rest;

import javax.ws.rs.Path;
import javax.ws.rs.GET;

@Path("/helloJST")
public class HelloJSTService {
	
	@GET
	public String getMessage(){
		return new String("HelloJST");
	}

}
