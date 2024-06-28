package cl.praxis.desafiomicalculadora;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "calcularServlet", value = "/calcular")
public class OperacionesMatematicasServlet extends HttpServlet {
    private String message;
    private String symbol;

    public void init() {
        message = "";
        symbol = "";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        int num1 = Integer.parseInt(request.getParameter("numero1"));
        int num2 = Integer.parseInt(request.getParameter("numero2"));
        int resultado;
        String operacion = request.getParameter("operacion");

        switch(operacion.toLowerCase()) {
            case "sumar":
                resultado = num1 + num2;
                symbol = "+";
                break;
            case "restar":
                resultado = num1 - num2;
                symbol= "-";
                break;
            case "multiplicar":
                resultado = num1 * num2;
                symbol = "*";
                break;
            case "dividir":
                resultado = num1 / num2;
                symbol = "/";
                break;
            default: resultado = 0;
                break;
        }

        message += num1 + " " + symbol + " " + num2 + " = " + resultado;

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.printf("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}