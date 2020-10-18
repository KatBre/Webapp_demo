<%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 2020-10-18
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Grade Form</title>
    <jsp:include page="headers.jsp"/>
</head>
<body>
<div class="container">
    <jsp:include page="navigator.jsp"/>
    <form action="${pageContext.request.contextPath}/grade/form" method="post">
        <%--        <div>--%>
        <%--            <label>Student id:</label>--%>
        <input type="hidden" value="${requestScope.studentIdAttribute}" readonly name="studentId"/>
        <%--        </div>--%>
        <div>
            <label>Value:</label>
            <input type="number" step="0.5" min="1" max="6" name="value_field"
                   value="${requestScope.modifiedGrade.value}"/>
        </div>
        <div>
            <label>Subject:</label>
            <select name="subject_field">
                <c:forEach items="${requestScope.availableSubjects}" var="subject">
                    <option value="${subject}"
                            <c:if test="${requestScope.modifiedGrade.subject==subject}">selected</c:if>>${subject.commonName}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit">Submit</button>
        <button type="reset">Reset</button>
    </form>
</div>
<jsp:include page="footers.jsp"/>
</body>
</html>
