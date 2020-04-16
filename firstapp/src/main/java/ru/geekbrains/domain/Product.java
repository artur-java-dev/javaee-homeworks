package ru.geekbrains.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.dto.ProductDTO;

import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Data
@NoArgsConstructor
@Table(name = "products")
public class Product
{

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Column(name = "title", nullable = false, unique = true)
  private String title;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "price", nullable = false)
  private BigDecimal price;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;


  public Product(ProductDTO dto)
  {
	title = dto.getTitle();
	description = dto.getDescription();
	price = dto.getPrice();
  }


  public Product setFrom(ProductDTO dto)
  {
	title = dto.getTitle();
	description = dto.getDescription();
	price = dto.getPrice();
	return this;
  }

}