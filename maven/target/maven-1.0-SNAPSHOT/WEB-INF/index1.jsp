<%@ page import="com.google.appengine.api.blobstore.*" %>

<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>

<!DOCTYPE html>

<html>
	<head>
		<title>Envoi de fichiers dans le Cloud</title>
		<meta charset="utf-8" />
	</head>

	<body>
		<h1>Envoyez un fichier dans le Cloud !</h1>
		<form action="<%= blobstoreService.createUploadUrl("/upload") %>" method="post" enctype="multipart/form-data">
			<p>
				<label>Fichier à envoyer : <input type="file" name="uploadedFile" /></label>
			</p>
			<p>
				<label>Description du fichier : <input type="text" name="description" /></label>
			</p>
			<p>
				<input type="submit" />
			</p>
		</form>
        </body>
</html>