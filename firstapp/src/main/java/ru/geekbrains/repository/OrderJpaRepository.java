package ru.geekbrains.repository;


import ru.geekbrains.domain.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;


@Stateless
@Transactional
public class OrderJpaRepository
		implements Serializable
{

  @PersistenceContext(unitName = "data-source")
  protected EntityManager em;


  public Order insert(Order order)
  {
	em.persist(order);
	return order;
  }


  public void update(Order order)
  {
	em.refresh(order);
  }


  public void delete(Long id)
  {
	Order order = em.find(Order.class, id);
	em.remove(order);
  }


  public List<Order> findAll()
  {
	CriteriaBuilder builder = em.getCriteriaBuilder();

	CriteriaQuery<Order> query = builder.createQuery(Order.class);
	Root<Order> from = query.from(Order.class);
	query.select(from);

	return em.createQuery(query)
			 .getResultList();
  }


  public Order findByID(Long id)
  {
	return em.find(Order.class, id);
  }

}