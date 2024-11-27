<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Note Taker : Home page</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>

	<div class="container">

		<%@include file="navbar.jsp"%>
		<h2>Please fill your note details</h2>


		<!--this is add form  -->
		<form action="SaveNoteServlet" method="post">
			<div class="form-group">
				<label for="title">Note Title</label>
				 <input
				  name="title"
				  required
				  type="text"
				  class="form-control" id="title"
				  aria-describedby="emailHelp"
				  placeholder="Enter here"/>
			</div>
			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea 
				name="content"
				id="content"
				 placeholder="Enter your content here"
				class="form-control" 
				style="height: 250px"></textarea>
			</div>
			<div class="Container text-center">
				<button type="submit" class="btn btn-primary">Add</button>
			</div>
		</form>


	</div>
</body>
</html>