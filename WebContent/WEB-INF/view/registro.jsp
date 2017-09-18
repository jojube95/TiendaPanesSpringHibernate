<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/stylesheetcss.css" />
</head>
<body>
<form:form action="registrar" modelAttribute="cliente" method="POST">
<div class="table-users">
   <div class="header">Registrar</div>
	<table style="text-align: left; width: 100%;" border="1" cellpadding="2" cellspacing="2">
	  <tbody>
	    <tr>
	      <td style="vertical-align: top; width: 181px;">Nombre:<br>
	      </td>
	      <td style="vertical-align: top; width: 522px;"><form:input path="nombre" /><br>
	      </td>
	    </tr>
	    <tr>
	      <td style="vertical-align: top; width: 181px;">Localidad:<br>
	      </td>
	      <td style="vertical-align: top; width: 522px;"><form:input path="localidad" /><br>
	      </td>
	    </tr>
	    <tr>
	      <td style="vertical-align: top; width: 181px;">Fecha Nacimiento(YYYY-MM-DD):<br>
	      </td>
	      <td style="vertical-align: top; width: 522px;"><form:input path="fechaNacimiento" /><br>
	      </td>
	    </tr>
	    <tr>
	      <td style="vertical-align: top; width: 181px;">Usuario:<br>
	      </td>
	      <td style="vertical-align: top; width: 522px;"><form:input path="usuario" /><br>
	      </td>
	    </tr>
	    <tr>
	      <td style="vertical-align: top; width: 181px;">Contraseña:<br>
	      </td>
	      <td style="vertical-align: top; width: 522px;"><form:input path="contrasenya" /><br>
	      </td>
	    </tr>
	    <tr>
	      <td style="vertical-align: top; width: 181px;"><input name="action" type="submit" value="registrarUsuario"><br>
	      </td>
	      <td style="vertical-align: top; width: 522px;"><input type="button" value="Cancelar registro" onclick="window.location.href='home'; return false;" class="add-button"><br>
	      </td>
	    </tr>
	  </tbody>
	</table>
</div>
</form:form>

  <br>

</body>
</html>