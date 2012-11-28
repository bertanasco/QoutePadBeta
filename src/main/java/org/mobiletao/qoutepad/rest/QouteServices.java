package org.mobiletao.qoutepad.rest;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mobiletao.qoutepad.dao.QouteDao;
import org.mobiletao.qoutepad.dao.QouteDaoImpl;

import java.io.*;

@Path("/qoute")
public class QouteServices {
	//TODO inject
	private QouteDao dao = new QouteDaoImpl();
	private static final Log log = LogFactory.getLog(QouteServices.class);
	
	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Restful example : " + msg;
		return Response.status(200).entity(result).build();

	}

	@GET
	@Path("/getqoute/{fileName}")
	@Produces("text/xml")
	public Response getQouteFile(@PathParam("fileName") final String fileName){
		/* read the requestBodyStream like a normal input stream */
		/* read the requestBodyStream like a normal input stream */
		StreamingOutput so = new StreamingOutput() {

			public void write(OutputStream os) throws IOException, WebApplicationException {
				InputStream is = getClass().getResourceAsStream("/resources/" + fileName + ".xml");
				int read = 0;  
				byte[] bytes = new byte[2000];  
				while ((read = is.read(bytes)) != -1) {  
					os.write(bytes, 0, read);  
				}
			}
		};
		
		ResponseBuilder response = Response.ok((Object) so);
		response.header("Content-Disposition",
			"attachment; filename=\"file_from_server.log\"");
		return response.build();
	}

	@GET
	@Path("/getqoutebytitle/{title}")
	@Produces("text/xml")
	public Response getQouteByTitle(@PathParam("title") String title){
		log.info("Entered getqouteservice");
		File qouteFile = new File("/resources/" + title + ".xml");
		InputStream is = getClass().getResourceAsStream("/resources/" + title + ".xml");
		
		//FileInputStream s = new FileInputStream();
		return Response.status(200).entity(qouteFile).build();
		//return null;
	}

	/*private Qoute getQouteDetailsFromDB(final String title){
		final Qoute qoute = dao.findByTitle(title);
		return null;

	}*/
}

