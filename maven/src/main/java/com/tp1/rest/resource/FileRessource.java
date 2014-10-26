package com.tp1.rest.resource;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.sun.jersey.multipart.FormDataParam;



@Path("/file")
public class FileRessource {
	
	private final static String PATH_UPLOAD_FILE = "C:/test/zik.mp3";
	//private final static String PATH_UPLOAD_FILE = "/WEB-INF/test/foo.txt";
			//"/src/ressource/kalifa.mp3";
	
	
	
	 @GET
	 @Path("get")
	    @Produces(MediaType.TEXT_PLAIN)
	    public String reponsePret() {
		 //LogQuery
		 String vare = "";
	        File file = new File(PATH_UPLOAD_FILE);
	        System.out.println("non null");
			 vare = "existe";
			System.out.println(file.getPath() +"--"+ file.getName() );
	        
	        return vare.toString() +" --" +file.getAbsolutePath().toString() + " Service Rest est pret";
	   
}

	    
	 
	 
/*
    @POST
   	@Path("upload")
   	@Consumes(MediaType.MULTIPART_FORM_DATA)
   	//public Response uploadFile(
    public String uploadFile(
   		@FormDataParam("file") InputStream uploadedInputStream) {
   		//System.out.println("connect�");
   		
   		// Save the file Rest Service
   		//writeFile(uploadedInputStream, PATH_UPLOAD_FILE);
    	
    	
    	
   		// response
   		String uploadPath = "File uploaded to : " + PATH_UPLOAD_FILE;
    
   		//return Response.status(200).entity(uploadPath).build();
   		return uploadPath;
   	}
    */
    

  /*  private void writeFile(InputStream uploadedInputStream, String PathUploadedFile) {
        try {
       			// Read the File
       			//OutputStream fileOutPut = new FileOutputStream(new File(PathUploadedFile));
        		int read = 0;
       			byte[] bytes = new byte[1024];
       			// New File
       			
       			fileOutPut = new FileOutputStream(new File(PathUploadedFile));

       			// Write  File
       			while ((read = uploadedInputStream.read(bytes)) != -1)
       			{
       				fileOutPut.write(bytes, 0, read);
       			}
       			// close
       			fileOutPut.flush();
       			fileOutPut.close();
       			
       			
       		} catch ( FileNotFoundException e1){
       			e1.printStackTrace();
       		} catch (IOException e) {
       			e.printStackTrace();
       		}
        
       	}
*/
   
/*
    @POST
   	@Path("uploadGAE")
   	@Consumes(MediaType.MULTIPART_FORM_DATA)
   	//public Response uploadFile(
    public String uploadFileGAE(
   		@FormDataParam("file") InputStream uploadedInputStream) {
    
    	
    	 
   		return "";
   	}
*/
    
    }

    
    
    

