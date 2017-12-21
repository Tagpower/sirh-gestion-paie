<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<form>
			<div class="form-group row">
			  <label for="form-matricule" class="col-2 col-form-label">Matricule</label>
			  <div class="col-10">
			    <input class="form-control" type="text" value="" id="form-matricule">
			  </div>
			</div>
			<div class="form-group row">
				<label for="selectEntreprise" class="col-2 col-form-label">Entreprise</label>
				<select class="custom-select" id="selectEntreprise">
					<c:forEach items="${entreprises}" var="e">
						<option value="${e.getId()} "> ${e.getDenomination()} </option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group row">
				<label for="selectProfil" class="col-2 col-form-label">Profil</label>
				<select class="custom-select" id="selectProfil">
					<c:forEach items="${profils}" var="p">
						<option value="${p.getId()} "> ${p.getCode()} </option>
					</c:forEach>
				</select>
			</div>		
			<div class="form-group row">
				<label for="selectGrade" class="col-2 col-form-label">Grade</label>
				<select class="custom-select" id="selectGrade">
					<c:forEach items="${grades}" var="g">
						<option value="${g.getId()} "> ${g.getCode()} </option>
					</c:forEach>
				</select>
			</div>	
			
			<div class="form-group row" style="text-align:right">
				<button type="submit" class="btn btn-primary">Ajouter</button>
			</div>
				
		</form>





	</div>

</body>
</html>