package com.tp1.rest.resource;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Request;

import com.tp1.rest.model.Person;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import com.tp1.rest.model.Person;


@Path("/person")
public class PersonRessource {
	
	
	// Var
    private final static String NAME = "name";
    private Person person = new Person("Pringles");
  
    private String res = null;
    
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String reponsePret() {
        return "Service Rest est pret";
    }
    
    
    @GET
    @Path("/2")
    @Produces(MediaType.TEXT_PLAIN)
    public String reponsePretChannel() {
        
    	

    	
    	
    	
    	
    	return "Service Rest est pret";
        
    }
    
   
   
    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String postPerson (MultivaluedMap<String, String> personParams ) {
    	
        String firstName = personParams.getFirst(NAME).toString();
        person.setName(firstName);
        
        if ( person.getName()!= ""){
        	this.res = "validation";
        }
        else{ this.res = "pas de validation" ; }
        
        /* Perso
        String output = " Form parameters :\n";
        for (String key : personParams.keySet())
        {
        	output += key + " : " + personParams.getFirst(key) +"\n";
         }
        
        System.out.println(output);
        System.out.println("person info: " + person.getName());
        */
         return res;                
    }
    
    
    
    
}
    
