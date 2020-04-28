package ru.geekbrains.service;


import ru.geekbrains.dto.ProductDTO;
import ru.geekbrains.service.model.CartItem;

import javax.ejb.Stateful;
import java.math.BigDecimal;
import java.util.*;

import static java.math.BigDecimal.ZERO;


@Stateful
public class CartServiceImpl
		implements CartService
{

  private Map<Long, CartItem> itemsByProductID;


  public CartServiceImpl()
  {
	itemsByProductID = new HashMap<>();
  }


  @Override
  public void addProduct(ProductDTO prod, int count)
  {
	if (itemsByProductID.containsKey(prod.getId()))
	{
	  CartItem item = itemsByProductID.get(prod.getId());
	  item.increaseCountBy(count);
	  return;
	}

	CartItem item = new CartItem(prod, count);
	itemsByProductID.put(prod.getId(), item);
  }


  @Override
  public void removeProduct(ProductDTO prod, int count)
  {
	if (!itemsByProductID.containsKey(prod.getId()))
	  throw new IllegalArgumentException("Cart are not contains passed product");

	CartItem item = itemsByProductID.get(prod.getId());

	if (item.getCount() > count)
	  item.decreaseCountBy(count);
	else
	  itemsByProductID.remove(prod.getId());
  }


  @Override
  public void removeProduct(ProductDTO prod)
  {
	if (!itemsByProductID.containsKey(prod.getId()))
	  throw new IllegalArgumentException("Cart are not contains passed product");

	itemsByProductID.remove(prod.getId());
  }


  @Override
  public void updateCart(CartItem item)
  {
	itemsByProductID.put(item.getProduct().getId(), item);
  }


  @Override
  public List<CartItem> getCartItems()
  {
	return new ArrayList<>(itemsByProductID.values());
  }


  @Override
  public BigDecimal getSubTotal()
  {
	Collection<CartItem> items = itemsByProductID.values();

	BigDecimal subTotal = items.stream()
							   .map(CartItem::getTotalPrice)
							   .reduce(ZERO, BigDecimal::add);
	return subTotal;
  }

}