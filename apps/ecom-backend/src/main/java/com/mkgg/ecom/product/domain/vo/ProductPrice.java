package com.mkgg.ecom.product.domain.vo;

import com.mkgg.ecom.shared.error.domain.Assert;

public record ProductPrice(double value) {

  public ProductPrice {
    Assert.field("value", value).min(0.1);
  }
}
