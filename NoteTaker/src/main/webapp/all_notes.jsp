<%@page import="org.hibernate.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.entities.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All notes Taker</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>

	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>
		<h2 class="text-uppercase">All Notes:</h2>
		<div class=row>

			<div class="col-12">
				<%
				Session s = FactoryProvider.getFactory().openSession();
				Query q = s.createQuery("from Note");
				List<Note> list = q.list();
				for (Note note : list) {
				%>

				<div class="card m-5">
					<img class="card-img-top m-4 mx-auto" style="max-width:80px;" src="img/pencil.png" alt="Card image cap">
					<div class="card-body px-5">
						<h5 class="card-title"><%=note.getTitle() %></h5>
						<p class="card-text"><%=note.getContent() %></p>
						<p><b class="text-primary"><%=note.getAddedDate() %></b> </p>
						<div class="conatiner text-center">
						<a href="DeleteServlet?note_id=<%= note.getId() %>" class="btn btn-danger">Delete</a>
						<a href="Edit.jsp?note_id=<%=note.getId() %>" class="btn btn-primary">Update</a>
						
						</div>
					</div>
				</div>

				<%
				}

				s.close();
				%>

			</div>

		</div>

	</div>
</body>
</html>