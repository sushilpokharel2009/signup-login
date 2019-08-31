
<%@ page import = "java.util.*" %>
<%@ page import = "com.stosh.pensionerModal.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% 
	
		List<Pensioner>pnList =  (ArrayList)request.getAttribute("sList1");
	
	%>
	
	
	<table>
	
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Password</th>
			<th>Address</th>
		</tr>
		
		
		<% for(Pensioner pnr : pnList){%>
		<tr>
			<td><%= pnr.getId() %></td>
			<td><%= pnr.getFirstName() %></td>
			<td><%= pnr.getLastName() %></td>
			<td><%= pnr.getPassword() %></td>
			<td><%= pnr.getAddress() %></td>
			<%--  <td><a href = "PensionerSignUpServlet?idForEdit=<%= pnr.getId()%>"></a></td>
			<td><a href = "PensionerSignUpServlet?idForDelete=<%= pnr.getId()%>"></a></td>  --%>
		</tr>
		<%} %>
	
	
	</table>
	
	
	
	
</body>
</html>