package ru.geekbrains.controller;


import ru.geekbrains.service.interfaces.CategoryService;
import ru.geekbrains.service.interfaces.dto.CategoryDTO;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named("categContr")
@SessionScoped
public class CategoryController
		implements Serializable
{

  @Inject
  private CategoryService categoryService;
  private CategoryDTO category;


  public CategoryDTO getCategory()
  {
	return category;
  }


  public void setCategory(CategoryDTO c)
  {
	category = c;
  }


  public String add()
  {
	category = new CategoryDTO();
	return "/category.xhtml?faces-redirect=true";
  }


  public List<CategoryDTO> getAll()
  {
	return categoryService.getAll();
  }


  public String edit(CategoryDTO category)
  {
	setCategory(category);
	return "/category.xhtml?faces-redirect=true";
  }


  public void remove(CategoryDTO category)
  {
	categoryService.remove(category);
  }


  public String save()
  {
	categoryService.save(category);
	return "/categories.xhtml?faces-redirect=true";
  }

}