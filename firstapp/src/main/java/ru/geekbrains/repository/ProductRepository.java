package ru.geekbrains.repository;


import ru.geekbrains.DataSource;
import ru.geekbrains.domain.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Named
@ApplicationScoped
public class ProductRepository
		implements Serializable
{

  @Inject
  private DataSource dataSource;
  private Connection conn;


  @PostConstruct
  public void init()
  throws SQLException
  {
	conn = dataSource.getConnection();
	createTable();
  }


  private void createTable()
  throws SQLException
  {
	try (Statement stmt = conn.createStatement())
	{
	  String sql = "create table if not exists products (" +
				   "id bigserial," +
				   "title varchar(50) not null," +
				   "description varchar(1000) not null," +
				   "price decimal(19,2) not null," +
				   "primary key (id));";
	  stmt.execute(sql);
	}
  }


  public List<Product> findAll()
  throws SQLException
  {
	List<Product> products = new ArrayList<>();

	try (Statement stmt = conn.createStatement())
	{
	  String sql = "select id, title, description, price from products";
	  ResultSet rs = stmt.executeQuery(sql);
	  while (rs.next())
	  {
		Product p = new Product(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4));
		products.add(p);
	  }
	}

	return products;
  }


  public void delete(Long id)
  throws SQLException
  {
	try (PreparedStatement stmt = conn.prepareStatement("delete from products where id = ?"))
	{
	  stmt.setLong(1, id);
	  stmt.execute();
	}
  }


  public void insert(Product product)
  throws SQLException
  {
	String sql = "insert into products(title, description, price) values (?, ?, ?)";

	try (PreparedStatement stmt = conn.prepareStatement(sql))
	{
	  stmt.setString(1, product.getTitle());
	  stmt.setString(2, product.getDescription());
	  stmt.setBigDecimal(3, product.getPrice());
	  stmt.execute();
	}
  }


  public void update(Product product)
  throws SQLException
  {
	String sql = "update products set title = ?, description = ?, price = ? where id = ?";

	try (PreparedStatement stmt = conn.prepareStatement(sql))
	{
	  stmt.setString(1, product.getTitle());
	  stmt.setString(2, product.getDescription());
	  stmt.setBigDecimal(3, product.getPrice());
	  stmt.setLong(4, product.getId());
	  stmt.execute();
	}
  }

}