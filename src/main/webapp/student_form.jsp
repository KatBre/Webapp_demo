<%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 2020-10-17
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Student Form</title>
    <jsp:include page="headers.jsp"/>
</head>
<body>
<div class="container">
    <jsp:include page="navigator.jsp"/>
    <form action="${pageContext.request.contextPath}/student/form" method="post">
        <input type="hidden" name="modifiedStudentId" value="${requestScope.modifiedStudent.id}">
        <div>
            <label>First name:</label>
            <input type="text" name="first_name_field" value="${requestScope.modifiedStudent.firstName}"/>
        </div>
        <div>
            <label>Last name:</label>
            <input type="text" name="last_name_field" value="${requestScope.modifiedStudent.lastName}"/>
        </div>
        <div>
            <label>Date of birth:</label>
            <input type="date" name="date_of_birth_field" value="${requestScope.modifiedStudent.birthDate}"/>
        </div>
        <div>
            <label>
                <input type="checkbox" name="graduated_field"
                       <c:if test="${requestScope.modifiedStudent.graduated}">checked</c:if>>
                <span>Graduated</span>
            </label>
        </div>
        <div>
            <label>Home distance:</label>
            <input type="number" step="0.01" name="distance_field"
                   value="${requestScope.modifiedStudent.homeDistance}"/>
        </div>
        <button type="submit">Submit</button>
        <button type="reset">Reset</button>
    </form>
</div>
<jsp:include page="footers.jsp"/>
</body>
</html>
