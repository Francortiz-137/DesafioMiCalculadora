<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: Ancort
  Date: 28-06-2024
  Time: 4:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initialscale=1.0">
    <link rel="stylesheet"
          href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <title>Error</title>
</head>
<body>
<section class="container text-center">
    <div>
        <div class="">
            <h1><%
                String message = null;
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if ("message".equals(cookie.getName())) {
                            message = URLDecoder.decode(cookie.getValue(), "UTF-8");
                            break;
                        }
                    }
                }
                if (message != null) {
                    out.print(message);
                } else {
                    out.print("No se encontró ningún mensaje.");
                }
            %></h1>
        </div>
    </div>
    <div>
        <a role="button" class="button" href="index.jsp">Regresar</a>
    </div>
</section>
</body>
</html>

