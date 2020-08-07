package by.itacademy;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ThirdServlet", urlPatterns = "/third")
public class ThirdServlet extends HttpServlet {

  LocalDateTime timestamp;
  final DateTimeFormatter FORMATTER;
  private static final Logger LOG = Logger.getLogger(ThirdServlet.class.getName());

  {
    FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    timestamp = LocalDateTime.now();

    try {
      throw new RuntimeException("timestamp: " + timestamp.format(FORMATTER));
    } catch (RuntimeException e) {
      LOG.info( e.getMessage());
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    timestamp = LocalDateTime.now();

    try {
      throw new RuntimeException("timestamp: " + timestamp.format(FORMATTER));
    } catch (RuntimeException e) {
      LOG.info( e.getMessage());
    }
  }
}
