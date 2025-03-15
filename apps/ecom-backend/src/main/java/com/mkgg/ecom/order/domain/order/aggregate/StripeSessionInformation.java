package com.mkgg.ecom.order.domain.order.aggregate;

import com.mkgg.ecom.order.domain.order.vo.StripeSessionId;
import com.mkgg.ecom.order.domain.user.vo.UserAddressToUpdate;
import org.jilt.Builder;

import java.util.List;

@Builder
public record StripeSessionInformation(StripeSessionId stripeSessionId,
                                       UserAddressToUpdate userAddress,
                                       List<OrderProductQuantity> orderProductQuantity) {
}
