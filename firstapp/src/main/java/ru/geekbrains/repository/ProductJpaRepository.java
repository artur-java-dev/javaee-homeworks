package ru.geekbrains.repository;


import ru.geekbrains.domain.Product;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;


@Stateless
@Transactional
public class ProductJpaRepository
		implements Serializable
{

  @PersistenceContext(unitName = "data-source")
  protected EntityManager em;


  public Product insert(Product product)
  {
	em.persist(product);
	return product;
  }


  public void update(Product product)
  {
	em.merge(product);
  }


  public void delete(Long id)
  {
	Product product = em.find(Product.class, id);
	em.remove(product);
  }


  public List<Product> findAll()
  {
	String q = "SELECT p FROM Product p";
	TypedQuery<Product> query = em.createQuery(q, Product.class);
	return query.getResultList();
  }


  public Optional<Product> findByID(Long id)
  {
	Product prod = em.find(Product.class, id);
	return ofNullable(prod);
  }


  public Optional<Product> findByTitle(String title)
  {
	String q = "SELECT p FROM Product p WHERE p.title = :title";
	TypedQuery<Product> query = em.createQuery(q, Product.class);
	query.setParameter("title", title);

	try
	{
	  return ofNullable(query.getSingleResult());
	}
	catch (NoResultException e)
	{
	  return empty();
	}
  }


  public List<Product> findByCategory(Long categoryId)
  {
	String q = "SELECT p FROM Product p WHERE p.category.id = :id";
	TypedQuery<Product> query = em.createQuery(q, Product.class);
	query.setParameter("id", categoryId);

	return query.getResultList();
  }

}