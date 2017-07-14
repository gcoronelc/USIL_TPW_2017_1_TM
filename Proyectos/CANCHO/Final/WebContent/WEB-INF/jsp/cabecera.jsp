<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>

  <table width="100%">
    <tr>  
    	<td><img src="<c:url value='/img/Insignia.gif' />" alt="" /></td>
      	<td>Usuario: ${ empSession.nombre }</td>
       	<td><a href="index.htm">Salir</a></td>
      
    </tr>
  </table>
</div>