package ru.geekbrains.service;


import ru.geekbrains.domain.Category;
import ru.geekbrains.dto.CategoryDTO;
import ru.geekbrains.repository.CategoryJpaRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

import static java.util.stream.Collectors.toList;


@Stateless
public class CategoryService
{

  @Inject
  private CategoryJpaRepository catRepo;


  public List<CategoryDTO> getAll()
  {
	return catRepo.findAll()
				  .stream()
				  .map(CategoryDTO::new)
				  .collect(toList());
  }


  public void remove(CategoryDTO dto)
  {
	Long id = dto.getId();
	catRepo.delete(id);
  }


  public void save(CategoryDTO dto)
  {
	if (dto.getId() == null)
	{
	  catRepo.insert(new Category(dto));
	  return;
	}

	Category cat = catRepo.findByID(dto.getId());
	cat.setFrom(dto);
	catRepo.update(cat);
  }

}