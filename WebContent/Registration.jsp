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

<h1>Employee Registration Form</h1>

	<form >
	Employee Name :
	<input type="text" id="name" placeholder="Full Name" name="name"/>
	<span id="sp"></span><br /><br />
	Employee Password:
	<input type="password" name="password" placeholder="Password" size="10" pattern="[a-z A-Z 0-9 !@#$%&*]{8,}" required ><br /><br />
	Favorite Color:
	<input type="color" name="color"/><br /><br />
	Employment Date:
	<input type="date" name="date" placeholder="DD/MM/YYYY"/><br /><br />
	E-Mail:
	<input type="text" name="e-mail" placeholder="abc@fgh.aa" pattern="[a-z0-9]+[@]{1}[a-z]+[.]{1}[a-z]+" required ><br /><br />
	Employee Gender:
	<input type="radio" name="gender" value="Male" checked/>Male
	<input type="radio" name="gender" value="Female"/>Female
	<br /><br />
	Cities lived in:
	<input class="city" type="checkbox" name="city" value="Bangalore"/>Bangalore
	<input class="city"  type="checkbox" name="city" value="Mysore"/>Mysore
	<input class="city" type="checkbox" name="city" value="Mumbai"/>Mumbai
	<input class="city" type="checkbox" name="city" value="Pune"/>Pune
	<span id="sp1"></span>
	<br /><br />
	Address:
	<textarea name="address" ></textarea><br /><br />
	Technologies:
	<select  name="tech" multiple>
		<option class="tech" value="PHP" >PHP</option>
		<option class="tech" value="HTML">HTML</option>
		<option class="tech" value="CSS">CSS</option>
		<option class="tech" value="Javascript">JavaScript</option>
	</select>
	<span id="sp2"></span></br/>
	<br />
	<input type="submit" value="Submit Form"/>
	<input type="reset" value="Reset Form"/>
	</form>

</body>
</html>