package ru.geekbrains.controller;


import lombok.SneakyThrows;
import ru.geekbrains.domain.Product;
import ru.geekbrains.repository.ProductRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named("prodContr")
@SessionScoped
public class ProductController
		implements Serializable
{

  @Inject
  private ProductRepository prodRepo;
  private Product product;


  public Product getProduct()
  {
	return product;
  }


  public void setProduct(Product p)
  {
	product = p;
  }


  public String add()
  {
	product = new Product();
	return "/product.xhtml?faces-redirect=true";
  }


  @SneakyThrows
  public List<Product> getAll()
  {
	return prodRepo.findAll();
  }


  public String edit(Product product)
  {
	setProduct(product);
	return "/product.xhtml?faces-redirect=true";
  }


  @SneakyThrows
  public void remove(Product product)
  {
	Long id = product.getId();
	prodRepo.delete(id);
  }


  @SneakyThrows
  public String save()
  {
	if (product.getId() == null)
	  prodRepo.insert(product);
	else
	  prodRepo.update(product);

	return "/products.xhtml?faces-redirect=true";
  }

}