package com.mkgg.ecom.product.domain.service;

import com.mkgg.ecom.product.domain.aggregate.FilterQuery;
import com.mkgg.ecom.product.domain.aggregate.Product;
import com.mkgg.ecom.product.domain.repository.ProductRepository;
import com.mkgg.ecom.product.domain.vo.PublicId;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class ProductShop {

  private ProductRepository productRepository;

  public ProductShop(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Page<Product> getFeaturedProducts(Pageable pageable) {
    return productRepository.findAllFeaturedProduct(pageable);
  }

  public Page<Product> findRelated(Pageable pageable, PublicId productPublicId) {
    Optional<Product> productOpt = productRepository.findOne(productPublicId);
    if (productOpt.isPresent()) {
      Product product = productOpt.get();
      return productRepository.findByCategoryExcludingOne(pageable,
        product.getCategory().getPublicId(),
        productPublicId);
    } else {
      throw new EntityNotFoundException(String.format("No product found with id %s", productPublicId));
    }
  }

  public Page<Product> filter(Pageable pageable, FilterQuery query) {
    return productRepository.findByCategoryAndSize(pageable, query);
  }
}
