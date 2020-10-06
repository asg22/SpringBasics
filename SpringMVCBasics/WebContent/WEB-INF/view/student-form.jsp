<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
		
		First Name:<form:input path="firstName"/>
		<br><br>
		Last Name:<form:input path="lastName"/>
		<br><br>
		Country :<form:select path="country">
		<form:option value="India">India</form:option>
		<form:options items="${theCountryOptions}"></form:options>
		<form:options items="${student.countryOptions}"></form:options>
		</form:select> 
		<br><br>
		Favorite Language:
		Java<form:radiobutton path="favLang" value="Java"/>
		C++<form:radiobutton path="favLang" value="C++"/>
		Python<form:radiobutton path="favLang" value="Python"/>
		<br><br>
		Operating Systems:
		Windows<form:checkbox path="opSys" value="Windows"/>
		Mac OS<form:checkbox path="opSys" value="Mac OS"/>
		Linux<form:checkbox path="opSys" value="Linux"/>
		<br><br>
		<input type="submit" value="submit"/>
		
	</form:form>
	

</body>
</html>