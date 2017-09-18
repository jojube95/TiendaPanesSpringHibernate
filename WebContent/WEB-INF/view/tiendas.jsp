<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/stylesheetcss.css" />
		  
<title>Insert title here</title>
</head>
<body>

<div class="table-users">
   <div class="header">Elige tu tienda</div>
	<table style="text-align: left; width: 100%;" border="1" cellpadding="2" cellspacing="2">
	  <tbody>
	    <tr class="tr:first-child">
	      <td style="vertical-align: top;">Nombre<br>
	      </td>
	      <td style="vertical-align: top;">Localidad<br>
	      </td>
	      <td style="vertical-align: top;"><br>
	      </td>
	    </tr>
	    
	    <c:forEach var ="tempTienda" items= "${tiendas}">
	    	<c:url var="linkComprar" value="comprar">
				<c:param name="idTienda" value="${tempTienda.idTienda }"></c:param>
				
			</c:url>
			
	    	<tr>
		      <td style="vertical-align: top;">${tempTienda.nombre}<br>
		      </td>
		      <td style="vertical-align: top;">${tempTienda.localidad}<br>
		      </td>
		      <td style="vertical-align: top;"><a href="${linkComprar}">Comprar</a><br>
		      </td>
	    	</tr>
	    </c:forEach>
	  </tbody>
	</table>
	<input align="middle" type="button" value="Volver" onclick="window.location.href='volverAUsuario'"/>
</div>





</html>