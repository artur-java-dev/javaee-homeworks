package ru.geekbrains.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order
{

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Column(name = "number", nullable = false, unique = true)
  private String number;

  @Column(name = "delivery_date", nullable = false, columnDefinition = "DATE")
  private LocalDate deliveryDate;

  @Column(name = "delivery_country", nullable = false)
  private String deliveryCountry;

  @Column(name = "delivery_city", nullable = false)
  private String deliveryCity;

  @Column(name = "delivery_street", nullable = false)
  private String deliveryStreet;

  @Column(name = "delivery_building_num", nullable = false)
  private Integer deliveryBuildingNum;

  @Column(name = "delivery_appartments_num")
  private Integer deliveryAppartmentsNum;

  @Column(name = "delivery_method", nullable = false)
  private String deliveryMethod;

  @Column(name = "payment_method", nullable = false)
  private String paymentMethod;

  @Column(name = "username", nullable = false)
  private String username;

  @OneToMany(mappedBy = "order", cascade = ALL)
  private List<OrderItem> items;

}