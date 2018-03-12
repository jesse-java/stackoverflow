<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
<form:form method="POST" action="/questions/create" modelAttribute="curr_question">
    <fieldset>
        <legend>New Question</legend>
        <form:label path="question">Question:
            <form:errors path="question"/>
            <form:textarea path="question"/>
        </form:label>

        <p><c:out value="${error}"/></p>

        <form:label path="tags">Tags:
            <form:errors path="tags"/>
            <form:input path="tags"/>
        </form:label>

        <input type="submit" value="Submit">
    </fieldset>
</form:form>
</body>
</html>