package com.mkgg.ecom.order.domain.order.aggregate;

import com.mkgg.ecom.product.domain.vo.PublicId;
import org.jilt.Builder;

@Builder
public record DetailCartItemRequest(PublicId productId, long quantity) {
}
