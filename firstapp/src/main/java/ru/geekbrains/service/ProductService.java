package ru.geekbrains.service;


import ru.geekbrains.domain.Category;
import ru.geekbrains.domain.Product;
import ru.geekbrains.dto.ProductDTO;
import ru.geekbrains.repository.CategoryJpaRepository;
import ru.geekbrains.repository.ProductJpaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;


@Named
@ApplicationScoped
public class ProductService
{

  @Inject
  private ProductJpaRepository productRepo;
  @Inject
  private CategoryJpaRepository catRepo;


  public List<ProductDTO> getAll()
  {
	return productRepo.findAll()
					  .stream()
					  .map(ProductDTO::new)
					  .collect(toList());
  }


  @Transactional
  public void remove(ProductDTO dto)
  {
	Long id = dto.getId();
	productRepo.delete(id);
  }


  @Transactional
  public void save(ProductDTO dto)
  {
	Category cat = catRepo.findByID(dto.getCategoryId());

	if (dto.getId() == null)
	{
	  Product product = new Product(dto);
	  product.setCategory(cat);
	  productRepo.insert(product);
	  return;
	}

	Product product = productRepo.findByID(dto.getId());
	product.setFrom(dto).setCategory(cat);
	productRepo.update(product);
  }

}