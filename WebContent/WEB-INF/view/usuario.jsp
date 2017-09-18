<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   		<div class="header"><h4>Usuario: <label>${sessionScope.cliente.usuario}</label></h4></div>
	
	<table class="th" style="text-align: left; width: 100%;" border="1" cellpadding="2" cellspacing="2">
		<tr>
	      <td style="vertical-align: top; width: 236px;"><input type="button" value="Comprar" onclick="window.location.href='mostrarTiendas'; return false;" class="add-button"><br>
	      </td>
	     </tr>
	    
	    <tr>
	      <td style="vertical-align: top; width: 236px;"><input type="button" value="Ver Compras" onclick="window.location.href='verCompras'; return false;" class="add-button"><br>
	      </td>
	     </tr>
	    
	    <tr>
	      <td style="vertical-align: top; width: 236px;"><input type="button" value="Log Out" onclick="window.location.href='logOut'; return false;" class="add-button"><br>
	      </td>
	     </tr>
	  
	      
	   
      
      
	</table>
	</div>
	


  

</body>
</html>