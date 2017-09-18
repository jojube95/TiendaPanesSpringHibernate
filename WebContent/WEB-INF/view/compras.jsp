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
</head>
<body>


<div class="table-users">
   <div class="header">Compras</div>
<table style="text-align: left; width: 493px;" border="1" cellpadding="2" cellspacing="2">
  <tbody>
    <tr>
      <td style="vertical-align: top; width: 109px;">IdCompra<br>
      </td>
      <td style="vertical-align: top; width: 109px;">Tienda<br>
      </td>
      <td style="vertical-align: top; width: 121px;">Fecha<br>
      </td>
      <td style="vertical-align: top; width: 108px;">Precio<br>
      </td>
      <td style="vertical-align: top; width: 121px;">Ver<br>
      </td>
    </tr>
    
    <c:forEach var ="tempCompra" items= "${compras}">
    	<!-- Link para cada compra con su campo clave -->
		<c:url var="linkVerCompra" value="panesCompra">
			<c:param name="idCompra" value="${tempCompra.idVenta }"></c:param>
		</c:url>
		
    	<tr>
	      <td style="vertical-align: top; width: 109px;">${tempCompra.idVenta }<br>
	      </td>
	      <td style="vertical-align: top; width: 109px;">${tempCompra.tienda.nombre }<br>
	      </td>
	      <td style="vertical-align: top; width: 121px;">${tempCompra.fecha }<br>
	      </td>
	      <td style="vertical-align: top; width: 108px;">${tempCompra.precio }<br>
	      </td>
	      <td style="vertical-align: top; width: 121px;"><a href="${linkVerCompra}">Ver</a><br>
	      </td>
    	</tr>
    </c:forEach>
  </tbody>
</table>
</div>
<br>
<input type="button" value="Volver" onclick="window.location.href='volverAUsuario'"/>
</body>
</html>