package ru.geekbrains.repository;


import ru.geekbrains.domain.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;


@Stateless
@Transactional
public class CategoryJpaRepository
		implements Serializable
{

  @PersistenceContext(unitName = "data-source")
  protected EntityManager em;


  public Category insert(Category category)
  {
	em.persist(category);
	return category;
  }


  public void update(Category category)
  {
	em.refresh(category);
  }


  public void delete(Long id)
  {
	em.createNamedQuery("Category.delete", Category.class)
	  .setParameter("id", id)
	  .executeUpdate();
  }


  public List<Category> findAll()
  {
	return em.createNamedQuery("Category.findAll", Category.class)
			 .getResultList();
  }


  public Category findByID(Long id)
  {
	return em.createNamedQuery("Category.findByID", Category.class)
			 .setParameter("id", id)
			 .getSingleResult();
  }

}