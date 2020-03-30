package controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/cart")
public class CartPageServlet
		extends HttpServlet
{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
  throws IOException, ServletException
  {
	req.getRequestDispatcher("/WEB-INF/cart.jsp").forward(req, resp);
  }

}