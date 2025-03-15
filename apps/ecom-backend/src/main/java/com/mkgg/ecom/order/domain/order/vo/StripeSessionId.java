package com.mkgg.ecom.order.domain.order.vo;

import com.mkgg.ecom.shared.error.domain.Assert;

public record StripeSessionId(String value) {

  public StripeSessionId {
    Assert.notNull("value", value);
  }
}
