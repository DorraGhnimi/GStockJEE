<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addProduit</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
</head>

<body>
<%@include file="header.jsp"%>


  <!-- pour md=midium 10 colennes, est decaler d'une clonne -->
	<div class="container col-md-8  col-md-offset-2 col-xs-12">
		<div class="panel panel-primary">
			<div class="panel-heading">add Produit</div>
			<div class="panel-body">
				<form action="save.php" method="post">
					<div class="form-group">
					 	<label class="control-label">Designation</label>
					 	<input type="text" name="designation" value="${produit.designation}" class="form-control" required="required"/>
					 	<span></span>
					</div>
					<div class="form-group">
					 	<label class="control-label">Prix</label>
					 	<input type="text" name="prix" value="${produit.prix}"  class="form-control"/>
					 	<span></span>
					</div>
					<div class="form-group">
					 	<label class="control-label">Quantite</label>
					 	<input type="text" name="quantite" value="${produit.quantite}"  class="form-control"/>
					 	<span></span>
					</div>
					<div>
						<button type="submit" class="btn btn-primary">Add</button>
					</div>			
				</form>			
			</div>
		</div>
	</div>
</body>
</html>