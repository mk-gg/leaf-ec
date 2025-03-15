package com.mkgg.ecom.order.domain.user.vo;

import com.mkgg.ecom.shared.error.domain.Assert;

public record UserLastname(String value) {

  public UserLastname {
    Assert.field("value", value).maxLength(255);
  }
}
