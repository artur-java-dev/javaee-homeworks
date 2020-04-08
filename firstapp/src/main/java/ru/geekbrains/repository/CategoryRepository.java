package ru.geekbrains.repository;


import ru.geekbrains.DataSource;
import ru.geekbrains.domain.Category;

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
public class CategoryRepository
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
	  String sql = "create table if not exists categories (" +
				   "id bigserial," +
				   "title varchar(50) not null," +
				   "primary key (id));";
	  stmt.execute(sql);
	}
  }


  public List<Category> findAll()
  throws SQLException
  {
	List<Category> categories = new ArrayList<>();

	try (Statement stmt = conn.createStatement())
	{
	  ResultSet rs = stmt.executeQuery("select id, title from categories");
	  while (rs.next())
	  {
		Category c = new Category(rs.getLong(1), rs.getString(2));
		categories.add(c);
	  }
	}

	return categories;
  }


  public void delete(Long id)
  throws SQLException
  {
	try (PreparedStatement stmt = conn.prepareStatement("delete from categories where id = ?"))
	{
	  stmt.setLong(1, id);
	  stmt.execute();
	}
  }


  public void insert(Category category)
  throws SQLException
  {
	String sql = "insert into categories(title) values (?)";

	try (PreparedStatement stmt = conn.prepareStatement(sql))
	{
	  stmt.setString(1, category.getTitle());
	  stmt.execute();
	}
  }


  public void update(Category category)
  throws SQLException
  {
	String sql = "update categories set title = ? where id = ?";

	try (PreparedStatement stmt = conn.prepareStatement(sql))
	{
	  stmt.setString(1, category.getTitle());
	  stmt.setLong(2, category.getId());
	  stmt.execute();
	}
  }

}