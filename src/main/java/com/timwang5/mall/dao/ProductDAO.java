package com.timwang5.mall.dao;

import com.timwang5.mall.pojo.Category;
import com.timwang5.mall.pojo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author timwong5
 * @date 2022-07-21 23:06
 */
public interface ProductDAO extends JpaRepository<Product,Integer> {
    Page<Product> findByCategory(Category category, Pageable pageable);
}
