package ru.geekbrains.service;


import ru.geekbrains.dto.CategoryDTO;
import ru.geekbrains.dto.ProductDTO;

import java.util.List;


public interface WebServiceInterface
{

  void addProduct(ProductDTO dto);

  void removeProduct(long id);

  void addCategory(CategoryDTO dto);

  ProductDTO getProduct(long id);

  ProductDTO getProduct(String title);

  List<ProductDTO> getAllProducts();

  List<ProductDTO> getProducts(long categoryId);

}