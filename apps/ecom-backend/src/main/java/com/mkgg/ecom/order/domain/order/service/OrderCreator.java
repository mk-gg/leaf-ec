package com.mkgg.ecom.order.domain.order.service;

import com.mkgg.ecom.order.domain.order.aggregate.DetailCartItemRequest;
import com.mkgg.ecom.order.domain.order.aggregate.DetailCartRequest;
import com.mkgg.ecom.order.domain.order.aggregate.Order;
import com.mkgg.ecom.order.domain.order.aggregate.OrderedProduct;
import com.mkgg.ecom.order.domain.order.repository.OrderRepository;
import com.mkgg.ecom.order.domain.order.vo.StripeSessionId;
import com.mkgg.ecom.order.domain.user.aggregate.User;
import com.mkgg.ecom.order.infrastructure.secondary.service.stripe.StripeService;
import com.mkgg.ecom.product.domain.aggregate.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderCreator {

  private final OrderRepository orderRepository;
  private final StripeService stripeService;

  public OrderCreator(OrderRepository orderRepository, StripeService stripeService) {
    this.orderRepository = orderRepository;
    this.stripeService = stripeService;
  }

  public StripeSessionId create(List<Product> productsInformations,
                                List<DetailCartItemRequest> items,
                                User connectedUser) {

    StripeSessionId stripeSessionId = this.stripeService.createPayment(connectedUser,
      productsInformations, items);

    List<OrderedProduct> orderedProducts = new ArrayList<>();

    for(DetailCartItemRequest itemRequest: items) {
      Product productDetails = productsInformations.stream()
        .filter(product -> product.getPublicId().value().equals(itemRequest.productId().value()))
        .findFirst().orElseThrow();

      OrderedProduct orderedProduct = OrderedProduct.create(itemRequest.quantity(), productDetails);
      orderedProducts.add(orderedProduct);
    }

    Order order = Order.create(connectedUser, orderedProducts, stripeSessionId);
    orderRepository.save(order);

    return stripeSessionId;
  }
}
