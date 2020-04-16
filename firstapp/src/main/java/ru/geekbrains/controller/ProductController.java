package ru.geekbrains.controller;


import ru.geekbrains.dto.ProductDTO;
import ru.geekbrains.service.ProductService;

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
  private ProductService prodService;
  private ProductDTO product;


  public ProductDTO getProduct()
  {
	return product;
  }


  public void setProduct(ProductDTO p)
  {
	product = p;
  }


  public String add()
  {
	product = new ProductDTO();
	return "/product.xhtml?faces-redirect=true";
  }


  public List<ProductDTO> getAll()
  {
	return prodService.getAll();
  }


  public String edit(ProductDTO product)
  {
	setProduct(product);
	return "/product.xhtml?faces-redirect=true";
  }


  public void remove(ProductDTO product)
  {
	prodService.remove(product);
  }


  public String save()
  {
	prodService.save(product);
	return "/products.xhtml?faces-redirect=true";
  }

}