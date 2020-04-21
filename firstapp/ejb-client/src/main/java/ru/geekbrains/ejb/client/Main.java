package ru.geekbrains.ejb.client;


import ru.geekbrains.service.interfaces.CategoryService;
import ru.geekbrains.service.interfaces.dto.CategoryDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import static java.lang.System.out;


public class Main
{

  public static void main(String[] args)
  throws IOException, NamingException
  {
	Context ctx = createInitialContext();

	CategoryService service =
			(CategoryService) ctx.lookup(
					"ejb:/firstapp//CategoryServiceImpl!ru.geekbrains.service.interfaces.CategoryService");

	List<CategoryDTO> categ = service.getAll();
	categ.forEach(p ->
						  out.println(p.getId() + " " + p.getTitle()));
  }


  public static Context createInitialContext()
  throws IOException, NamingException
  {
	Properties env = new Properties();
	ClassLoader cl = Main.class.getClassLoader();
	InputStream res = cl.getResourceAsStream("wildfly-jndi.properties");
	env.load(res);

	return new InitialContext(env);
  }

}