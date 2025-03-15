package com.mkgg.ecom.order.domain.user.vo;

import com.mkgg.ecom.shared.error.domain.Assert;

public record UserFirstname(String value) {

  public UserFirstname {
    Assert.field("value", value).maxLength(255);
  }
}
