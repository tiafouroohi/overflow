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

<h1>Dashboard</h1>

<c:forEach items="${allQuestions}" var="question">
<p><a href="/question/${question.id}"><c:out value="${question.name}"></c:out></a></p>
<c:forEach items="${question.tags }" var="tag">
<p><c:out value="${tag.name }"></c:out></p>

</c:forEach>
</c:forEach>


</body>
</html>