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
		    <a href='<c:url value="lister"/>'>Employés</a>  <a href='<c:url value="../bulletins/lister"/>'>Bulletins</a>
		  </span>
		</nav>
		
		<h1 style="text-align:center">Liste des employés</h1>
		
 <input type="button" class="btn btn-primary" value="Ajouter un employé" onclick="location.href = '<c:url value="creer" />';">

		<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>Date de création</th>
		        <th>Matricule</th>
		        <th>Grade</th>
		      </tr>
		    </thead>
			<c:forEach items="${employes}" var="e">
				<tr>
					<td> ${e.getDateCreation()} </td>
					<td> ${e.getMatricule()} </td>
					<td> ${e.getGrade().getCode()} </td>
				</tr>		
			</c:forEach>
			
		
		
		
		
		</table>
		
		
		
		
		
		
		
		
		
	</div>

</body>
</html>