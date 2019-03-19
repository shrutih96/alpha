<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=application.getInitParameter("Project")%>

<form action="DispServe">
<input type="text" name="name"/><br />
<input type="submit" value="Search By UserID" ><br />

<input type="submit" value="Display All" formaction="DisplayServlet"><br />
</form>

</body>
</html>