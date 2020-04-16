package ru.geekbrains.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.dto.CategoryDTO;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Data
@NoArgsConstructor
@NamedQueries({
					  @NamedQuery(name = "Category.delete",
								  query = "DELETE FROM Category c WHERE c.id = :id"),
					  @NamedQuery(name = "Category.findByID",
								  query = "SELECT c FROM Category c WHERE c.id = :id"),
					  @NamedQuery(name = "Category.findAll",
								  query = "SELECT c FROM Category c")
			  })
@Table(name = "categories")
public class Category
{

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Column(name = "title", nullable = false, unique = true)
  private String title;

  @OneToMany(orphanRemoval = true, mappedBy = "category")
  private List<Product> products;


  public Category(CategoryDTO dto)
  {
	title = dto.getTitle();
  }


  public void setFrom(CategoryDTO dto)
  {
	title = dto.getTitle();
  }

}