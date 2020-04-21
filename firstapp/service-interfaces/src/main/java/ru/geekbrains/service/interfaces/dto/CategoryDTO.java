package ru.geekbrains.service.interfaces.dto;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CategoryDTO
{

  private Long id;
  private String title;


  public CategoryDTO(long id, String title)
  {
	setId(id);
	setTitle(title);
  }

}