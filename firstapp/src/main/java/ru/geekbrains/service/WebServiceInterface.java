package ru.geekbrains.service;


import ru.geekbrains.dto.CategoryDTO;
import ru.geekbrains.dto.ProductDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface WebServiceInterface
{

  @WebMethod
  void addProduct(ProductDTO dto);

  @WebMethod
  void removeProduct(long id);

  @WebMethod
  void addCategory(CategoryDTO dto);

  @WebMethod
  ProductDTO getProduct(long id);

  @WebMethod
  ProductDTO getProductByTitle(String title);

  @WebMethod
  List<ProductDTO> getAllProducts();

  @WebMethod
  List<ProductDTO> getProducts(long categoryId);

}