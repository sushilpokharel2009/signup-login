<%@ page import = "com.stosh.pensionerModal.Comment" %>
<%@ page import = "com.stosh.pensionerModal.Pensioner" %>
<%@ page import = "java.util.*" %>




<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <h1>Hello, This is my Home Page after you logged in.</h1> -->
	 <%
			Pensioner comtd = (Pensioner)session.getAttribute("vfp");
			if(comtd != null){%>
		
		
		<h1>Welcome: <%= comtd.getFirstName() %> <%= comtd.getLastName() %></h1>
		<br>
		<br>
		
		
		<%}  else{
			response.sendRedirect("Signup.jsp");
		}%> 
		
	
	<form action="CommentServlet" method = "post">
		<h1>Please leaver your Comments</h1>
	
		<div>
			<input type ="text" name = "Commentator">
		</div>
		<br>
		
		<div>
			<textarea name="Message" rows="10" cols="150"></textarea>
		</div>
		<br>
		
		<div>
			<input type ="submit" name = "SubmittedBy">
		</div>

	</form>
	
	<h1>Comments</h1>
		<%
			List<Comment> commentList = (ArrayList)request.getAttribute("sta");
		    if(commentList == null){
			commentList = new ArrayList();
		}
		
		%>
		
		<!-- *****************************NAME********************************************************* -->
		<table>
				<tr>
					<th>Name</th>
					  <th>Comments</th>	
				</tr>						
			<% for(Comment ct :commentList){%>
				<tr>
					<%-- <td> <%= ct.getCompleteName() %> </td>	
					 <td><%= ct.getMessage() %>  </td> 	 --%>
					 
					 <td> <h4><%= ct.getCompleteName() %> </h4><br>
					 	<%= ct.getMessage() %>  </td> 			
				</tr>
			<%} %>
		</table>
		
		
		<!-- ***********************COMMENTS****************************************************** -->
		
		<%--  <table>
				<tr>
					<th>Comments</th>				
				</tr>						
			<% for(Comment ct :commentList){%>
				<tr>
					<td><%= ct.getMessage() %>  </td>				
				</tr>
			<%} %>
		</table>   --%>
		<!-- *************************FOR LOGOUT**************************************************** -->
		
		<h1><a href="Logout.jsp">LogOut</a></h1>
		
</body>
</html>