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
	
		<h1 style="text-align:center">Ajouter un employé</h1>

<%-- 		<form:form method="post" modelAttribute="employe"> --%>
<!-- 			<table> -->
<!-- 				<tr> -->
<!-- 					<td>Matricule</td> -->
<%-- 					<td><form:input path="matricule" /></td> --%>
<!-- 				</tr> -->
<!-- 			</table> -->
<%-- 		</form:form> --%>


		<form:form method="post" modelAttribute="employe">
			<div class="form-group row">
			  <label for="form-matricule" class="col-2 col-form-label">Matricule</label>
			  <div class="col-10" style="padding-left:0px">
				<form:input path="matricule" value="${prefixMatricule}" class="form-control"/>
			  </div>
			</div>
			<div class="form-group row">
				<label for="selectEntreprise" class="col-2 col-form-label">Entreprise</label>
				<form:select path="entreprise.id" id="selectEntreprise">
					<form:options items="${entreprises}" itemValue="id" itemLabel="denomination" />
				</form:select>
			</div>
			<div class="form-group row"> 
				<label for="selectProfil" class="col-2 col-form-label">Profil</label>
				<form:select path="profilRemuneration.id">
					<form:options items="${profils}" itemValue="id" itemLabel="code" />
				</form:select>
			</div>		
			<div class="form-group row">
				<label for="selectGrade" class="col-2 col-form-label">Grade</label>
				<form:select path="grade.id">
					<form:options items="${grades}" itemValue="id" itemLabel="code" />
				</form:select>
			</div>	
			
			<div class="form-group row" style="text-align:right">
				<button class="btn btn-primary float-right" onClick="submit">Ajouter un employé</button>			
			</div>
				
		</form:form>





	</div>

</body>
</html>