package com.mkgg.ecom.order.domain.user.aggregate;

import com.mkgg.ecom.order.domain.user.vo.AuthorityName;
import com.mkgg.ecom.shared.error.domain.Assert;
import org.jilt.Builder;

@Builder
public class Authority {

  private AuthorityName name;

  public Authority(AuthorityName authorityName) {
    Assert.notNull("name", authorityName);
    this.name = authorityName;
  }

  public AuthorityName getName() {
    return name;
  }
}
