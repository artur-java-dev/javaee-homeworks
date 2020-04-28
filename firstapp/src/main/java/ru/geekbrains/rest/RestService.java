package ru.geekbrains.rest;


import ru.geekbrains.domain.Category;
import ru.geekbrains.domain.Product;
import ru.geekbrains.dto.CategoryDTO;
import ru.geekbrains.dto.ProductDTO;
import ru.geekbrains.repository.CategoryJpaRepository;
import ru.geekbrains.repository.ProductJpaRepository;
import ru.geekbrains.service.WebServiceInterface;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;


@Path("/v1")
public class RestService
		implements WebServiceInterface
{

  @Inject
  private ProductJpaRepository productRepo;
  @Inject
  private CategoryJpaRepository catRepo;


  @Override
  @Path("/product/add")
  @Consumes(APPLICATION_JSON)
  @PUT
  public void addProduct(ProductDTO dto)
  {
	dto.setId(null);
	Product prod = new Product(dto);
	Category cat = catRepo.findByID(dto.getCategoryId());
	prod.setCategory(cat);
	productRepo.insert(prod);
  }


  @Override
  @Path("/product/remove/{id}")
  @DELETE
  public void removeProduct(@PathParam("id") long id)
  {
	getProduct(id);
	productRepo.delete(id);
  }


  @Override
  @Path("/category/add")
  @Consumes(APPLICATION_JSON)
  @PUT
  public void addCategory(CategoryDTO dto)
  {
	catRepo.insert(new Category(dto));
  }


  @Override
  @Path("/product/{id}")
  @Produces(APPLICATION_JSON)
  @GET
  public ProductDTO getProduct(@PathParam("id") long id)
  {
	Product prod = productRepo
						   .findByID(id)
						   .orElseThrow(() -> new WebApplicationException(NOT_FOUND));

	return new ProductDTO(prod);
  }


  @Override
  @Path("/product/title")
  @Produces(APPLICATION_JSON)
  @GET
  public ProductDTO getProduct(@QueryParam("title") String title)
  {
	Product prod = productRepo
						   .findByTitle(title)
						   .orElseThrow(() -> new WebApplicationException(NOT_FOUND));

	return new ProductDTO(prod);
  }


  @Override
  @Path("/products/all")
  @Produces(APPLICATION_JSON)
  @GET
  public List<ProductDTO> getAllProducts()
  {
	return productRepo.findAll()
					  .stream()
					  .map(ProductDTO::new)
					  .collect(toList());
  }


  @Override
  @Path("/products/{categoryId}")
  @Produces(APPLICATION_JSON)
  @GET
  public List<ProductDTO> getProducts(@PathParam("categoryId") long categoryId)
  {
	return productRepo.findByCategory(categoryId)
					  .stream()
					  .map(ProductDTO::new)
					  .collect(toList());
  }

}