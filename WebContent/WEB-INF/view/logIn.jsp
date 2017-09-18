<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/stylesheetcss.css" />
		  
</head>
<body>

<form:form action="logIn" modelAttribute="cliente" method="POST">
	<div class="table-users">
	   <div class="header">Login</div>
		<table class="th" style="text-align: left; width: 100%;" border="1" cellpadding="2" cellspacing="2">
		  <tbody>
		    <tr>
		      <td style="vertical-align: top; width: 236px;">Usuario:<br>
		      </td>
		      <td style="vertical-align: top; width: 467px;"><form:input path="usuario" /><br>
		      </td>
		    </tr>
		    <tr>
		      <td style="vertical-align: top; width: 236px;">Contraseña:<br>
		      </td>
		      <td style="vertical-align: top; width: 467px;"><form:password path="contrasenya" /><br>
		      </td>
		    </tr>
		    <tr>
		      <td style="vertical-align: top; width: 236px;"><input type="submit" name="action" value="logIn"><br>
		      </td>
		      <td style="vertical-align: top; width: 467px;"><input type="button" value="registrar" onclick="window.location.href='mostrarRegistrar'; return false;"
				   class="add-button"><br>
		      </td>
		    </tr>
		  </tbody>
		</table>
	</div>
		
		  <br>
</form:form>


</body>
</html>
