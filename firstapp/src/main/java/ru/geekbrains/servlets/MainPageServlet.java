package ru.geekbrains.servlets;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class MainPageServlet
		extends HttpServlet
{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
  throws IOException, ServletException
  {
	PrintWriter writer = resp.getWriter();
	writer.println("<html>");
	writer.println("<body>");
	writer.println("<h1>Главная</h1>");
	getServletContext().getRequestDispatcher("/navigation.html").include(req, resp);
	writer.println("</body>");
	writer.println("</html>");
  }

}