package controller;


import domain.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "Controller",
			urlPatterns = {"", "/main", "/catalog"})
public class Controller
		extends HttpServlet
{


  private List<Product> products;
  private static final String RESPONSE_TYPE = "text/html;charset=UTF-8";


  @Override
  public void init() throws ServletException
  {
	super.init();

	products = new ArrayList<Product>()
	{{
	  add(new Product(1L, "CPU Intel", 10000.00));
	  add(new Product(2L, "DDR4 SDRAM Kingston", 5000.00));
	  add(new Product(3L, "GEFORCE GTX 1050 Ti", 10000.00));
	  add(new Product(4L, "Radeon RX 580", 15000.00));
	  add(new Product(5L, "mouse Logitech", 1000.00));
	  add(new Product(6L, "keyboard Logitech", 1500.00));
	  add(new Product(7L, "monitor ASUS", 12000.00));
	  add(new Product(8L, "mainboard ASUS Z170", 8000.00));
	  add(new Product(9L, "network D-Link DFE-560FX", 4000.00));
	}};
  }


  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
  throws ServletException, IOException
  {
	String path = req.getServletPath();
	resp.setContentType(RESPONSE_TYPE);

	String url = "/WEB-INF/";
	switch (path)
	{
	  case "/":
	  case "/main":
		url += "index.jsp";
		break;
	  case "/catalog":
		req.setAttribute("products", products);
		url += "catalog.jsp";
		break;
	}

	RequestDispatcher disp = req.getRequestDispatcher(url);
	disp.forward(req, resp);
  }

}