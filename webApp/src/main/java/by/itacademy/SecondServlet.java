package by.itacademy;

import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SecondServlet", urlPatterns = "/second", loadOnStartup = 1)
public class SecondServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    BigDecimal firstNum, secondNum, result = null;
    String operation;

    try {
      firstNum = new BigDecimal(request.getParameter("firstNum"));
      secondNum = new BigDecimal(request.getParameter("secondNum"));
      operation = request.getParameter("operation");

      SimpleCalc calc = new SimpleCalc();

      switch (operation) {
        case "plus":
          result = calc.sum(firstNum, secondNum);
          operation = "+";
          break;
        case "minus":
          result = calc.minus(firstNum, secondNum);
          operation = "-";
          break;
        case "mul":
          result = calc.mul(firstNum, secondNum);
          operation = "*";
          break;
        case "div":
          result = calc.div(firstNum, secondNum);
          operation = "/";
          break;
      }

      if (result != null) {
        response.getWriter()
            .println(firstNum + " " + operation + " " + secondNum + " = " + result);
      } else {
        response.setCharacterEncoding("windows-1251");
        response.getWriter().println("Не удалось вычислить");
      }

    } catch (Exception e) {
      response.getWriter().println("Error of parameters: " + e.getMessage());
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ServletContext context = getServletContext();
    RequestDispatcher dispatcher = context.getRequestDispatcher("/first");
    dispatcher.forward(request, response);
  }
}
