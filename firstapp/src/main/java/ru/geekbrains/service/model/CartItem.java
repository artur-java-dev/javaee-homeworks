package ru.geekbrains.service.model;


import lombok.Data;
import ru.geekbrains.dto.ProductDTO;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;


@Data
public class CartItem
{

  private ProductDTO product;
  private int count;


  public CartItem(ProductDTO product, int count)
  {
	setProduct(product);
	setCount(count);
  }


  public void increaseCountBy(int count)
  {
	this.count += count;
  }


  public void decreaseCountBy(int count)
  {
	if (count >= this.count)
	  throw new IllegalArgumentException("arg exceed count");

	this.count -= count;
  }


  public BigDecimal getTotalPrice()
  {
	BigDecimal cnt = valueOf(count);
	BigDecimal total = product.getPrice().multiply(cnt);

	return total;
  }

}