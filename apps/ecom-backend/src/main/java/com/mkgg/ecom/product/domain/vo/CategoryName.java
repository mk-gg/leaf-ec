package com.mkgg.ecom.product.domain.vo;

import com.mkgg.ecom.shared.error.domain.Assert;

public record CategoryName(String value) {
  public CategoryName {
    Assert.field("value", value).notNull().minLength(3);
  }
}
