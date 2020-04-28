package ru.geekbrains.service.interfaces;


import ru.geekbrains.service.interfaces.dto.CategoryDTO;

import javax.ejb.Remote;
import java.io.Serializable;
import java.util.List;


@Remote
public interface CategoryService
		extends Serializable
{

  List<CategoryDTO> getAll();

  void remove(CategoryDTO dto);

  void save(CategoryDTO dto);

}