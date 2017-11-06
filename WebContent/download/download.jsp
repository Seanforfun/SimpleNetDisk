<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Download File</title>
</head>
<body>
	<h3><font color="purple">Download Page</font></h3>
	<c:if test="${empty files }">
		<font color="red">No files available</font>
	</c:if>
	<c:if test="${not empty files }">
		<form  method="post" id="formId">
			<table>
				<c:forEach var="f" items="${files }">
						<tr>
							<td>
								<input type="checkbox" value="${f.id }" name="ckb">
							</td>
							<td><a href="${pageContext.request.contextPath }/filedownload?filename=${f.realname }&savepath=${f.savepath}">${f.realname }</a></td>
							<td>${f.description }</td>
						</tr>
				</c:forEach>	
				<tr>
					<td><input type="button" value="Download" onclick="downloadFiles()"></td>
					<td><input type="button" value="Delete" onclick="deleteFiles()"></td>
				</tr>
			</table>
		</form>
	</c:if>
</body>
<script type="text/javascript">
	function downloadFiles()
	{
		var form = document.getElementById("formId");
		var pathName = window.document.location.pathname;
		 var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
		form.action = projectName + "/download";
		form.submit();
	}
	
	function deleteFiles()
	{
		var form = document.getElementById("formId");
		var pathName = window.document.location.pathname;
		 var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
		form.action = projectName + "/delete";
		form.submit();
	}
</script>
</html>