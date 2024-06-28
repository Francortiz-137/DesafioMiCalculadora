package cl.praxis.desafiomicalculadora;

import java.io.*;
import java.net.URLEncoder;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "calcularServlet", value = "/calcular")
public class OperacionesMatematicasServlet extends HttpServlet {
    private String message;
    private String symbol;

    public void init() {
        message = "";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String numero1Str = request.getParameter("numero1");
        String numero2Str = request.getParameter("numero2");
        String operacion = request.getParameter("operacion");
        String errorMsg = "";

        System.out.println(numero1Str);
        System.out.println(numero2Str);

        int num1;
        int num2;
        double resultado;
        try {
            num1 = Integer.parseInt(numero1Str);
            num2 = Integer.parseInt(numero2Str);
        } catch (NumberFormatException e) {
            // Redireccionar a página de error si los números no son válidos
            errorMsg = URLEncoder.encode("Los números ingresados no son válidos", "UTF-8");
            response.sendRedirect("error.jsp?error="+errorMsg);
            return;
        }
        try{
            switch(operacion.toLowerCase()) {
                case "sumar":
                    resultado = num1 + num2;
                    message = num1 + " " + "+" + " " + num2 + " = " + (int) resultado;
                    break;
                case "restar":
                    resultado = num1 - num2;
                    message = num1 + " " + "-" + " " + num2 + " = " + (int) resultado;
                    break;
                case "multiplicar":
                    resultado = num1 * num2;
                    message = num1 + " " + "*" + " " + num2 + " = " + (int) resultado;
                    break;
                case "dividir":
                    if (num2 == 0) {
                        errorMsg = URLEncoder.encode("No se puede dividir por cero", "UTF-8");
                        response.sendRedirect("error.jsp?error="+errorMsg);
                        return;
                    }
                    resultado = (double) num1 / num2;
                    message = num1 + " " + "/" + " " + num2 + " = " + resultado;
                    break;
                case "ordenar":
                    message = orderNumbers(num1,num2);
                    break;
                case "par":
                    message = areEven(num1,num2);
                default:
                    errorMsg = URLEncoder.encode("Operación no válida", "UTF-8");
                    response.sendRedirect("error.jsp?error="+errorMsg);
                    return;
            }
        } catch (Exception e) {
            // Capturar cualquier otra excepción y redireccionar a página de error general
            errorMsg = URLEncoder.encode("Error en el procesamiento de la operación", "UTF-8");
            response.sendRedirect("error.jsp?error="+errorMsg);
            return;
        }
        // Codificar el mensaje antes de añadirlo a la cookie
        String encodedMessage = URLEncoder.encode(message, "UTF-8");
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