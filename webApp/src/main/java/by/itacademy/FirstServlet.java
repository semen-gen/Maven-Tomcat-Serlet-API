package by.itacademy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    double firstNum, secondNum;
    Double result = null;
    String operation;

    try {
      firstNum = Double.parseDouble(request.getParameter("firstNum"));
      secondNum = Double.parseDouble(request.getParameter("secondNum"));
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
            .println(firstNum + " " + " " + operation + " " + " " + secondNum + " = " + result);
      } else {
        response.setCharacterEncoding("windows-1251");
        response.getWriter().println("Не удалось вычислить");
      }

    } catch (Exception e) {
      System.out.println("Error of parameters: " + e.getMessage());
    }
  }
}
