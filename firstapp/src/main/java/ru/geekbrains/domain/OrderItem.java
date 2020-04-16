package ru.geekbrains.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Data
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItem
{

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @OneToOne(optional = false)
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @Column(name = "count", nullable = false)
  private Integer count;

  @Column(name = "total_cost", nullable = false)
  private BigDecimal totalCost;


  @ManyToOne(optional = false)
  @JoinColumn(name = "order_id")
  private Order order;

}