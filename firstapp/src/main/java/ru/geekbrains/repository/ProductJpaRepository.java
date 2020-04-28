package ru.geekbrains.repository;


import ru.geekbrains.domain.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;


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


  public Product findByID(Long id)
  {
	return em.find(Product.class, id);
  }

}