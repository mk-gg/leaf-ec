package com.mkgg.ecom.order.domain.user.vo;

import com.mkgg.ecom.shared.error.domain.Assert;

public record AuthorityName(String name) {

  public AuthorityName {
    Assert.field("name", name).notNull();
  }
}
