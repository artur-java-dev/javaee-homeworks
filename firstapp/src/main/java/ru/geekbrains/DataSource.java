package ru.geekbrains;


import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.sql.*;


@Named
@ApplicationScoped
public class DataSource
{

  @Inject
  private ServletContext ctx;
  private Connection conn;


  @PostConstruct
  public void init()
  throws SQLException
  {
	String url = ctx.getInitParameter("dbURL");
	String user = ctx.getInitParameter("dbUsername");
	String password = ctx.getInitParameter("dbPassword");
	conn = DriverManager.getConnection(url, user, password);
	createAndSelectSchema();
  }


  private void createAndSelectSchema()
  throws SQLException
  {
	try (Statement stmt = conn.createStatement())
	{
	  String sql = "CREATE SCHEMA IF NOT EXISTS test_db; " +
				   "SET search_path TO test_db;";
	  stmt.execute(sql);
	}
  }


  public Connection getConnection()
  {
	return conn;
  }

}