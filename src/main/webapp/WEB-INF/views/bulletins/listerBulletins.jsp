<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="dev.paie.entite.RemunerationEmploye"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>PAIE</title>
	
	<link rel="stylesheet" href="/paie/bootstrap-4.0.0-beta.2-dist/css/bootstrap.css"/>
	
</head>

<body>

	<div class="container" style="margin:1em">
	
	<nav class="navbar navbar-light bg-faded">
	  <span class="navbar-text">
		 <a href='<c:url value="../employes/lister"/>'>Employés</a>  <a href='<c:url value="lister"/>'>Bulletins</a>
	  </span>
	</nav>
	
		<h1 style="text-align:center">Liste des bulletins</h1>
		
 <input type="button" class="btn btn-primary" value="Ajouter un bulletin" onclick="location.href = '<c:url value="creer" />';">

		<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>Date de création</th>
		        <th>Période</th>
		        <th>Matricule</th>
		        <th>Salaire brut</th>
		        <th>Net imposable</th>
		        <th>Net à payer</th>
		        <th>Actions</th>
		      </tr>
		    </thead>
			<c:forEach items="${bulletins}" var="b">
				<tr>
					<td> ${b.getRemunerationEmploye().getDateCreation()} </td>
					<td> ${b.getPeriode().toString()} </td>
					<td> ${b.getRemunerationEmploye().getMatricule()} </td>
					<td> TODO </td>
					<td> TODO </td>
					<td> TODO </td>
					<td> <a>TODO</a> </td>
				</tr>		
			</c:forEach>
			
		
		
		
		
		</table>
		
		
		
		
		
		
		
		
		
	</div>

</body>
</html>