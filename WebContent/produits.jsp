<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>produits</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
</head>

<body>
<%@include file="header.jsp"%>


  <!-- pour md=midium 10 colennes, est decaler d'une clonne -->
	<div class="container col-md-10 col-md-offset-1">
		<div class="panel panel-primary">
			<div class="panel-heading">recheche des produits</div>
			<div class="panel-body">
				<form action="chercher.php" method="get">
					<label>mot clé</label>
					<input type="text" name="motCle"   value="${model.motCle }" /><!-- ici balue pour data-binding -->
					<button type="submit" class="btn btn-primary">chercher</button>
				</form>	
				<table class="table table-striped"> 
					<tr>
						<th>ID</th>
						<th>Designation</th>
						<th>Prix</th>
						<th>Quantite</th>
					</tr>
					<c:forEach items = "${model.produits }" var ="p">
						<tr> 
							<td>${p.id}</td>
							<td>${p.designation}</td>
							<td>${p.prix}</td>
							<td>${p.quantite}</td>
							<td><a onclick="return confirm('mthabet !?!! -_- ')"  href="delete.php?id=${p.id}">Delete</a></td>
							<td><a href="edit.php?id=${p.id}">Edit</a></td>
						</tr>
					</c:forEach>
					
					
				</table>				
			</div>
		</div>
	</div>
</body>
</html>