<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*,serve.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%=application.getInitParameter("Project")%>

<table border=1>
<tr>
<th>UserID</th>
<th>Password</th>
</tr>


<%
	ArrayList<Data> al=(ArrayList)request.getAttribute("employee");

	Iterator it=al.iterator();
	while(it.hasNext()){		
		Data d= (Data)it.next();%>
		
		<tr>
		<td><%=d.getUserID() %></td>
		<td><%=d.getPassword() %></td>
		</tr>
<% 	}	%>		
</table>
<form action="AdminPage.jsp">
<input type="submit" value="BACK">
</form>	
</body>
</html>