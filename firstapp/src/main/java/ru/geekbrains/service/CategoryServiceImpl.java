package ru.geekbrains.service;


import ru.geekbrains.domain.Category;
import ru.geekbrains.repository.CategoryJpaRepository;
import ru.geekbrains.service.interfaces.CategoryService;
import ru.geekbrains.service.interfaces.dto.CategoryDTO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

import static java.util.stream.Collectors.toList;


@Stateless
public class CategoryServiceImpl
		implements CategoryService
{

  @Inject
  private CategoryJpaRepository catRepo;


  @Override
  public List<CategoryDTO> getAll()
  {
	return catRepo.findAll()
				  .stream()
				  .map(x -> new CategoryDTO(x.getId(), x.getTitle()))
				  .collect(toList());
  }


  @Override
  public void remove(CategoryDTO dto)
  {
	Long id = dto.getId();
	catRepo.delete(id);
  }


  @Override
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