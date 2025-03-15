package com.mkgg.ecom.order.domain.user.vo;

import com.mkgg.ecom.shared.error.domain.Assert;

public record UserImageUrl(String value) {

  public UserImageUrl {
    Assert.field("value", value).maxLength(1000);
  }
}
