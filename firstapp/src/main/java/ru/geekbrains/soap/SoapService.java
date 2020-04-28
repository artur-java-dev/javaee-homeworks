package ru.geekbrains.soap;


import ru.geekbrains.dto.CategoryDTO;
import ru.geekbrains.dto.ProductDTO;
import ru.geekbrains.rest.RestService;
import ru.geekbrains.service.WebServiceInterface;

import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;


@WebService(endpointInterface = "ru.geekbrains.service.WebServiceInterface")
public class SoapService
		implements WebServiceInterface
{

  @Inject
  private RestService service;


  @Override
  public void addProduct(ProductDTO dto)
  {
	service.addProduct(dto);
  }


  @Override
  public void removeProduct(long id)
  {
	service.removeProduct(id);
  }


  @Override
  public void addCategory(CategoryDTO dto)
  {
	service.addCategory(dto);
  }


  @Override
  public ProductDTO getProduct(long id)
  {
	return service.getProduct(id);
  }


  @Override
  public ProductDTO getProductByTitle(String title)
  {
	return service.getProductByTitle(title);
  }


  @Override
  public List<ProductDTO> getAllProducts()
  {
	return service.getAllProducts();
  }


  @Override
  public List<ProductDTO> getProducts(long categoryId)
  {
	return service.getProducts(categoryId);
  }

}