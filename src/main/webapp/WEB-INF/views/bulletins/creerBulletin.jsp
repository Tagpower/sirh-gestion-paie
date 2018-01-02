<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="dev.paie.entite.RemunerationEmploye"%>
<%@page import="dev.paie.entite.BulletinSalaire"%>
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
	
		<h1 style="text-align:center">Créer bulletin de salaire</h1>

<%-- 		<form:form method="post" modelAttribute="employe"> --%>
<!-- 			<table> -->
<!-- 				<tr> -->
<!-- 					<td>Matricule</td> -->
<%-- 					<td><form:input path="matricule" /></td> --%>
<!-- 				</tr> -->
<!-- 			</table> -->
<%-- 		</form:form> --%>


		<form:form method="post" modelAttribute="bulletin"> <%-- FIXME --%>
			<div class="form-group row">
				<label for="selectPeriode" class="col-2 col-form-label">Période</label>
				<form:select path="periode.id" id="selectPeriode">
					<form:options items="${periodes}" itemValue="id" itemLabel="test" />
				</form:select>
			</div>
			<div class="form-group row">
			  <label for="form-matricule" class="col-2 col-form-label">Matricule</label>
			  <div class="col-10" style="padding-left:0px">
				<form:input path="matricule" value="${prefixMatricule}" class="form-control"/>
			  </div>
			</div>
			<div class="form-group row">
				<label for="selectEmploye" class="col-2 col-form-label">Entreprise</label>
				<form:select path="employe.id" id="selectmployee">
					<form:options items="${employes}" itemValue="id" itemLabel="matricule" />
				</form:select>
			</div>
			<div class="form-group row">
			  <label for="form-prime" class="col-2 col-form-label">Prime exceptionnelle</label>
			  <div class="col-10" style="padding-left:0px">
				<form:input path="prime" value="${prime}" class="form-control"/>
			  </div>
			</div>
			
			<div class="form-group row" style="text-align:right">
				<button class="btn btn-primary float-right" onClick="submit">Ajouter un employé</button>			
			</div>
				
		</form:form>





	</div>

</body>
</html>