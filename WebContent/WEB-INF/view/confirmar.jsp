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
<br>
Usuario: <label>${sessionScope.cliente.usuario}</label>
<br>
Tienda: <label>${sessionScope.tienda.nombre}</label>
<br>

<div class="table-users">
   <div class="header">Confirma compra</div>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2" cellspacing="2">
  <tbody>
    <tr>
      <td style="vertical-align: top;">Nombre<br>
      </td>
      <td style="vertical-align: top;">Tipo<br>
      </td>
      <td style="vertical-align: top;">Cantidad<br>
      </td>
      <td style="vertical-align: top;">Precio<br>
      </td>
    </tr>
    
    <c:forEach var ="tempPanes" items= "${sessionScope.compra.panVentas}">
    	<tr>
	      <td style="vertical-align: top;">${tempPanes.id.panTienda.pan.nombre}<br>
	      </td>
	      <td style="vertical-align: top;">${tempPanes.id.panTienda.pan.tipo}<br>
	      </td>
	      <td style="vertical-align: top;">${tempPanes.cant}<br>
	      </td>
	      <td style="vertical-align: top;">${tempPanes.id.panTienda.pan.precio}<br>
	      </td>
	    </tr>
    
    </c:forEach>
  </tbody>
</table>
</div>
<div class="table-users">
<table style="text-align: left; width: 100%;" border="1" cellpadding="2" cellspacing="2">
	<tr>
		<td>
		Precio total:
		</td>
		<td>
		 <label>${sessionScope.compra.precio}</label>
		</td>
	</tr>
</table>
</div>
<div class="table-users">
<form name="formulario" method="post" action="confirmar">
<table style="text-align: left; width: 111px;" border="1" cellpadding="2" cellspacing="2">
  <tbody>
    <tr>
      <td style="vertical-align: top; width: 0px;"><input type="submit" name="boton" value="aceptar" /><br>
      </td>
      <td style="vertical-align: top; width: 43px;"><input type="button" value="cancelar" onclick="window.location.href='volverACompra'; return false;" class="add-button"><br>
      </td>
    </tr>
  </tbody>
</table>
</form>
</div>
<br>

  

</body>
</html>