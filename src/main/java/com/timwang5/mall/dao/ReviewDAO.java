package com.timwang5.mall.dao;

import com.timwang5.mall.pojo.Product;
import com.timwang5.mall.pojo.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author timwong5
 * @date 2022-08-09 11:09
 */
public interface ReviewDAO extends JpaRepository<Review, Integer> {
    List<Review> findByProductOrderByIdDesc(Product product);
    int countByProduct(Product product);
}
