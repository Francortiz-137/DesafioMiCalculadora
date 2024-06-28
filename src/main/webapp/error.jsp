<%--
  Created by IntelliJ IDEA.
  User: Ancort
  Date: 28-06-2024
  Time: 4:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String message = request.getParameter("error");
%>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initialscale=1.0">
    <link rel="stylesheet"
          href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
    <title>Error</title>
</head>
<body>
<section class="container text-center">
    <div class="flex">
        <div class="">
            <h1>Error</h1>
            <p><%=message%></p>
        </div>
    </div>
    <div>
        <a role="button" class="button" href="index.jsp">Regresar</a>
    </div>
</section>

</body>
</html>
