<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>New Question</h1>

<form:form action="/question" method="post" modelAttribute="question">



<p>
<form:label path="name">Question</form:label>
<form:errors path="name"></form:errors>
<form:input path="name"></form:input>
</p>


<label for="tags">Tags</label>
<input name="tag"></input>
<input type="submit" value="Submit"/>

</form:form>

</body>
</html>