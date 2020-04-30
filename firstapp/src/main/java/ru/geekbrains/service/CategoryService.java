package ru.geekbrains.service;


import ru.geekbrains.dto.CategoryDTO;

import java.io.Serializable;
import java.util.List;


public interface CategoryService
		extends Serializable
{

  List<CategoryDTO> getAll();

  void remove(CategoryDTO dto);

  void save(CategoryDTO dto);

}