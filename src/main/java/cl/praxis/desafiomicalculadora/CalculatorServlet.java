package cl.praxis.desafiomicalculadora;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "calcularServlet", value = "/calcular")
public class CalculatorServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String number1Str = request.getParameter("numero1");
        String number2Str = request.getParameter("numero2");
        String operation = request.getParameter("operacion");
        String errorMsg;

        System.out.println(number1Str);
        System.out.println(number2Str);
        System.out.println(operation);

        int num1;
        int num2;
        double result;
        try {
            num1 = Integer.parseInt(number1Str);
            num2 = Integer.parseInt(number2Str);
        } catch (NumberFormatException e) {
            errorMsg = URLEncoder.encode("Los números ingresados no son válidos", StandardCharsets.UTF_8);
            response.sendRedirect("error.jsp?error="+errorMsg);
            return;
        }
        try{
            switch(operation.toLowerCase()) {
                case "sumar":
                    result = num1 + num2;
                    message = num1 + " " + "+" + " " + num2 + " = " + (int) result;
                    break;
                case "restar":
                    result = num1 - num2;
                    message = num1 + " " + "-" + " " + num2 + " = " + (int) result;
                    break;
                case "multiplicar":
                    result = num1 * num2;
                    message = num1 + " " + "*" + " " + num2 + " = " + (int) result;
                    break;
                case "dividir":
                    if (num2 == 0) {
                        errorMsg = URLEncoder.encode("No se puede dividir por cero", StandardCharsets.UTF_8);
                        response.sendRedirect("error.jsp?error="+errorMsg);
                        return;
                    }
                    result = (double) num1 / num2;
                    message = num1 + " " + "/" + " " + num2 + " = " + result;
                    break;
                case "ordenar":
                    message = orderNumbers(num1,num2);
                    break;
                case "par":
                    message = areEven(num1,num2);
                    break;
                default:
                    errorMsg = URLEncoder.encode("Operación no válida", StandardCharsets.UTF_8);
                    response.sendRedirect("error.jsp?error="+errorMsg);
                    return;
            }
        } catch (Exception e) {
            // Capturar cualquier otra excepción y redireccionar a página de error general
            errorMsg = URLEncoder.encode("Error en el procesamiento de la operación", StandardCharsets.UTF_8);
            response.sendRedirect("error.jsp?error="+errorMsg);
            return;
        }
        // Codificar el mensaje antes de añadirlo a la cookie
        String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8);
        Cookie cookie = new Cookie("message", encodedMessage);
        response.addCookie(cookie);
        response.sendRedirect("exito.jsp");

    }

    private String areEven(int num1, int num2) {
        String resultado = "";
        if(num1%2 == 0){
            resultado += num1 + " es Par. ";
        }else{
            resultado += num1 + " es Impar. ";
        }
        if(num2%2 == 0){
            resultado += num2 + " es Par.";
        } else{
            resultado += num2 + " es Impar.";
        }
        return resultado;
    }

    private String orderNumbers(int num1, int num2) {
        if (num1 > num2) {
            return num1 + " > "+ num2;
        } else if (num2 > num1) {
            return num2 + " > "+ num1;
        }   else {
            return num1 + " == "+ num2;
        }
    }

    public void destroy() {
    }
}