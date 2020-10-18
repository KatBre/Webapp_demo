<%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 2020-10-18
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Student Details</title>
    <jsp:include page="headers.jsp"/>
</head>
<body>
<div class="container">
    <jsp:include page="navigator.jsp"/>
    <h1>${requestScope.studentToDisplay.firstName} ${requestScope.studentToDisplay.lastName}</h1>
    <div>
        <div>
            <table>
                <tr>
                    <td>Imie:</td>
                    <td>${requestScope.studentToDisplay.firstName}</td>
                </tr>
                <tr>
                    <td>Nazwisko:</td>
                    <td>${requestScope.studentToDisplay.lastName}</td>
                </tr>
                <tr>
                    <td>Graduated:</td>
                    <td>${requestScope.studentToDisplay.graduated}</td>
                </tr>
                <tr>
                    <td>Home distance:</td>
                    <td>${requestScope.studentToDisplay.homeDistance}</td>
                </tr>
                <tr>
                    <td>Birth date:</td>
                    <td>${requestScope.studentToDisplay.birthDate}</td>
                </tr>
                <tr>
                    <td>Age:</td>
                    <td>${requestScope.studentToDisplay.age}</td>
                </tr>
            </table>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/grade/form?studentId=${requestScope.studentToDisplay.id}">Add
                grade</a>
            <table>
                <tr>
                    <th>Id</th>
                    <th>Value</th>
                    <th>Date</th>
                    <th>Subject</th>
                    <th>Actions</th>
                </tr>
                <c:forEach items="${requestScope.studentToDisplay.gradeSet}" var="grade">
                    <tr>
                        <td>${grade.id}</td>
                        <td>${grade.value}</td>
                        <td>${grade.timeCreated}</td>
                        <td>${grade.subject.commonName}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/grade/remove?gradeId=${grade.id}">Remove</a>
                            <a href="${pageContext.request.contextPath}/grade/edit?gradeId=${grade.id}">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="footers.jsp"/>
</body>
</html>
