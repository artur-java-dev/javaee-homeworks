package ru.geekbrains.domain;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Category
{

  private Long id;
  private String title;


  public Category(long id, String title)
  {
	setId(id);
	setTitle(title);
  }

}