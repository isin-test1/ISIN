package com.tp1.rest.resource;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;









import org.jvnet.mimepull.MIMEConfig;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;

import com.google.api.client.util.IOUtils;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.files.AppEngineFile;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.files.FileWriteChannel;

@Path("gae")
public class GAE {

@POST
@Path("upload")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response post(
		@FormDataParam("file") InputStream stream, 
		@FormDataParam("file") FormDataContentDisposition disposition) throws IOException {
  //post(file, disposition.getFileName());
	BlobKey aBlobKey = null;
	Long keyaBlock = null;
	try {
	
	String fileName = disposition.getFileName();
	
	String link = getStringFromInputStream(stream);
	if ( link != ""){
		try {
			aBlobKey = SaveFile(link,fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
String output = "File saved to server location ;";

return Response.status(200).entity(aBlobKey.getKeyString()).build() ;


}


private static String getStringFromInputStream(InputStream is) {
	 
	BufferedReader br = null;
	StringBuilder sb = new StringBuilder();

	String line;
	try {
		br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}

	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	return sb.toString();
}


	

private static BlobKey SaveFile(String link, String fileName)
		throws Exception {
	BlobKey result = null;
	URL url = new URL(link);
	//InputStream input = new URL(link).openStream();

	//String myString = IOUtils.toString(link, "UTF-8");
	
	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	try {
		connection.setInstanceFollowRedirects(false);
		connection.setRequestMethod("GET");
		connection.setConnectTimeout(10000);

		FileService fileService = FileServiceFactory.getFileService();

		Integer code = connection.getResponseCode();
		if (code == HttpURLConnection.HTTP_OK) {
			String contentType = connection.getHeaderField("Content-type");
			InputStream is = connection.getInputStream();

			AppEngineFile file = fileService.createNewBlobFile(contentType,fileName);
			boolean lock = true;
			FileWriteChannel writeChannel = fileService.openWriteChannel(file, lock);
			OutputStream os = Channels.newOutputStream(writeChannel);

			byte[] buf = new byte[4096];
			ByteArrayOutputStream bas = new ByteArrayOutputStream();
			int n;
			while ((n = is.read(buf)) >= 0)
				bas.write(buf, 0, n);
			os.write(bas.toByteArray());
			os.close();
			writeChannel.closeFinally();

			return fileService.getBlobKey(file);
		}
	} finally {
		connection.disconnect();
	}
	return result;
}


}
