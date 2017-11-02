<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload File</title>
</head>
<body>
	<h3><font color="purple">Upload page</font></h3>
	<form method="post" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
		<input type="file" name="f" ><br>
		<font color="purple">description:</font><input type="text" name="description"><br>
		<div id="divId"></div>
		<input type="submit" value="upload">
		<input type="button" value="Add File" onclick="addFile()">
	</form>
</body>
<script type="text/javascript">
	function addFile()
	{
		var div = document.getElementById("divId");
		div.innerHTML += "<div><input type='file' name='f'><input type='button' value='remove' onclick='remove(this)'><br><font color='purple'>description:</font><input type='text' name='description'><br></div>"
	}
	
	function remove(btn)
	{
		document.getElementById("divId").removeChild(btn.parentNode);
	}
</script>
</html>