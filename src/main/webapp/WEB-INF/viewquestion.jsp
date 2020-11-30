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



<h1><c:out value="${question.name }"></c:out></h1>

<c:forEach items="${question.tags }" var="tag">
<c:out value="${tag.name }"></c:out>
</c:forEach>

<form action="/question/${question.id }" method="post">
    <p>
        <label path="answer">Add an Answer</label>
        <errors path="answer"/>
        <input name="answer"/>
    </p>
    <input type="submit" value="Submit"/>
</form>

<h3>Answers</h3>


<c:forEach items="${question.answers }" var="answer">
<c:out value="${answer.answer }"></c:out>
</c:forEach>



</body>
</html>