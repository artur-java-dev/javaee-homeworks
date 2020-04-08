package ru.geekbrains.controller;


import lombok.SneakyThrows;
import ru.geekbrains.domain.Category;
import ru.geekbrains.repository.CategoryRepository;

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
  private CategoryRepository categRepo;
  private Category category;


  public Category getCategory()
  {
	return category;
  }


  public void setCategory(Category c)
  {
	category = c;
  }


  public String add()
  {
	category = new Category();
	return "/category.xhtml?faces-redirect=true";
  }


  @SneakyThrows
  public List<Category> getAll()
  {
	return categRepo.findAll();
  }


  public String edit(Category category)
  {
	setCategory(category);
	return "/category.xhtml?faces-redirect=true";
  }


  @SneakyThrows
  public void remove(Category category)
  {
	Long id = category.getId();
	categRepo.delete(id);
  }


  @SneakyThrows
  public String save()
  {
	if (category.getId() == null)
	  categRepo.insert(category);
	else
	  categRepo.update(category);

	return "/categories.xhtml?faces-redirect=true";
  }

}