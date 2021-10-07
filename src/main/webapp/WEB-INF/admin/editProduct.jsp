<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form class="admin-box" action="/editProduct/${product.id}" method="POST" enctype="multipart/form-data">

<div class="form_wrapper">
<label class="form_label" for="name">Name: </label>
<input class="form_input" type="text" name="name" />
</div>

<div class="form_wrapper">
<label class="form_label" for="price">Price: </label>
<input class="form_input" type="number" step="0.01" name="price" />
</div>

<div class="form_wrapper">
<label class="form_label" for="img_url">Photo: </label>
<input class="form_input" type="file" step="0.01" name="img_url" />
</div>

<input class="form_submit" type="submit" value="Create" />
</form>
</body>
</html>