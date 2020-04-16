package ru.geekbrains.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.domain.Category;


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


  public CategoryDTO(Category category)
  {
	this(category.getId(), category.getTitle());
  }

}