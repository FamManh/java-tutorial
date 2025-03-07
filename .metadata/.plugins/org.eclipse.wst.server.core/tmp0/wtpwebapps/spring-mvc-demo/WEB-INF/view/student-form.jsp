<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration Form</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">
    	First name: <form:input path="firstName" />
    	<br />
    	Last name: <form:input path="lastName" />
    	<br />
    	Country: 
    	<form:select path="country">
    		<form:options items="${student.countryOptions}" />
    	</form:select>
    	<br />
    	<input type="submit" value="Submit" />
    	
    </form:form>
</body>
</html>





