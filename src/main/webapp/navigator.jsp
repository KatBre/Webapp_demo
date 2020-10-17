<%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 2020-10-17
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


<%--  http://serwer.com/kontekst/minionki  --%>
<%--        =->   multiplication.jsp ->  http://serwer.com/kontekst/minionki/multiplication.jsp --%>
<%--        =->   /multiplication.jsp ->  http://serwer.com/kontekst/multiplication.jsp --%>
<%--        =->   / ->  http://serwer.com/ --%>
<%--        =->   / ->  http://serwer.com/kontekst/ --%>
<ul>
    <li>
        <a href="${pageContext.request.contextPath}/">Home</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/multiplication.jsp">Tabliczka mnożenia</a>
    </li>
</ul>
