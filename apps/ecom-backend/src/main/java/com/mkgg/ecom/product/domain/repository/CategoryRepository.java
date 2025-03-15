package com.mkgg.ecom.product.domain.repository;

import com.mkgg.ecom.product.domain.aggregate.Category;
import com.mkgg.ecom.product.domain.vo.PublicId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryRepository {

  Page<Category> findAll(Pageable pageable);

  int delete(PublicId publicId);

  Category save(Category categoryToCreate);

}
