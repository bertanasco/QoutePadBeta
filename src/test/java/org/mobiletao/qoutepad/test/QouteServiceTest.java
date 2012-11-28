package org.mobiletao.qoutepad.test;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import org.junit.Test;
import org.mobiletao.qoutepad.rest.QouteServices;

import java.io.*;

public class QouteServiceTest extends JerseyTest{
	
	private static String TEST_FILE_NAME = "test.xml";
	
	public QouteServiceTest() {
		super(QouteServices.class.getPackage().getName());
	}
	
	/*@Test
	public void getQoute(){
		
		WebResource resource = resource();
		resource.accept(MediaType.TEXT_XML);
		File qouteFile =  resource.path("QouteService/getQoute/" + TEST_FILE_NAME ).get(File.class);
		assertEquals(TEST_FILE_NAME, qouteFile.getName());
		
	}*/

}
