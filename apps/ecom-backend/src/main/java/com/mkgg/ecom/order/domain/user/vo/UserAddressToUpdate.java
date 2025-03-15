package com.mkgg.ecom.order.domain.user.vo;

import com.mkgg.ecom.shared.error.domain.Assert;
import com.mkgg.ecom.shared.error.domain.MissingMandatoryValueException;
import org.jilt.Builder;

@Builder
public record UserAddressToUpdate(UserPublicId userPublicId, UserAddress userAddress) {

  public UserAddressToUpdate {
    Assert.notNull("value", userPublicId);
    Assert.notNull("value", userAddress);
  }
}
