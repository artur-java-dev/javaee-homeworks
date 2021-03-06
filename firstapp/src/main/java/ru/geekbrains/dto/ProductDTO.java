package ru.geekbrains.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.domain.Product;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.*;
import java.math.BigDecimal;


@Named
@RequestScoped
@Data
@NoArgsConstructor
public class ProductDTO
{

  private Long id;

  @NotNull(message = "Обязательное поле")
  @Size(max = 50, message = "Поле должно содержать до 50 символов")
  private String title;

  @NotNull(message = "Обязательное поле")
//  @Size(min = 25, max = 1000, message = "Поле должно содержать от 25 до 1000 символов")
  private String description;

  @NotNull(message = "Обязательное поле")
  @DecimalMin(value = "1")
  @Digits(integer = 17, fraction = 2, message = "Целая часть должна содержать не более 17 цифр")
  private BigDecimal price;

  private Long categoryId;


  public ProductDTO(Long id, String title, String description, double price)
  {
	this(id, title, description, new BigDecimal(price));
  }


  public ProductDTO(Long id, String title, String description, BigDecimal price)
  {
	setId(id);
	setTitle(title);
	setDescription(description);
	setPrice(price);
  }


  public ProductDTO(Product product)
  {
	id = product.getId();
	title = product.getTitle();
	description = product.getDescription();
	price = product.getPrice();
	categoryId = product.getCategory().getId();
  }

}