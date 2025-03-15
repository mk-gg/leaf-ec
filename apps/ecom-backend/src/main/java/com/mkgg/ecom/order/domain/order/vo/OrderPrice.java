package com.mkgg.ecom.order.domain.order.vo;

import com.mkgg.ecom.shared.error.domain.Assert;

public record OrderPrice(double value) {

  public OrderPrice {
    Assert.field("value", value).strictlyPositive();
  }
}
