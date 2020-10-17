<%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 2020-10-17
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Index page</title>
    <jsp:include page="headers.jsp"/>
</head>
<body>
<div class="container">
<jsp:include page="navigator.jsp"/>
<h1>
<%
      // Java code
    String nameParam = request.getParameter("name");
    if(nameParam == null){
        out.print("Hello user!");
    }else {
        out.print("Hello " + nameParam + "!");
    }
%>
</h1>
</div>
<jsp:include page="footers.jsp"/>
</body>
</html>
