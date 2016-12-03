package com.bsu.rest;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
 
@Path("/hello")
public class HelloWorldService {

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		 FileOutputStream fs;
		 ObjectOutputStream os;

		 System.out.println("Мы тута!");
		try {
			System.out.println("А тперь  тута!");
			fs = new FileOutputStream(new File("/Users/Kayuga/Downloads/RESTfulExample/src/main/java/com/bsu/rest/HelloVovan.txt"));
			os = new  ObjectOutputStream(fs);
			System.out.println("Вроде как сделали файли");
			os.writeChars(msg);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String output = "Hello : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
 
}