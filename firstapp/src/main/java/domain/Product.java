package domain;


import java.math.BigDecimal;


public class Product
{

  private Long id;
  private String title;
  private BigDecimal price;


  public Product(Long id, String title, double price)
  {
	setId(id);
	setTitle(title);
	setPrice(new BigDecimal(price));
  }


  public Long getId()
  {
	return id;
  }


  public void setId(Long id)
  {
	this.id = id;
  }


  public String getTitle()
  {
	return title;
  }


  public void setTitle(String title)
  {
	this.title = title;
  }


  public BigDecimal getPrice()
  {
	return price;
  }


  public void setPrice(BigDecimal price)
  {
	this.price = price;
  }

}