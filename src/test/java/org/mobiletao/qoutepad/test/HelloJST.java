package org.mobiletao.qoutepad.test;

import static org.junit.Assert.*;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import org.junit.Test;
import org.mobiletao.qoutepad.rest.HelloJSTService;

public class HelloJST extends JerseyTest {
	
	public HelloJST(){
		
		super(HelloJSTService.class.getPackage().getName());
	}
	
	@Test 
	public void helloJSTTest(){
		WebResource resource = resource();
		String message = resource.path("helloJST").get(String.class);
		assertEquals("HelloJST", message);
	}

}
