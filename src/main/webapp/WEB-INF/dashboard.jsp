<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<body>
<h1>Questions Dashboard</h1>

<table>
    <tr>
        <th>Question</th>
        <th>Tags</th>
    </tr>
    <c:forEach items="${questions}" var="q" >
        <tr>
            <td><c:out value="${q.question}"/></td>
        </tr>
    </c:forEach>

    <a href="<c:url value="/questions/new"/>">New Question</a>
</table>
</body>

</html>