package com.timwang5.mall.dao;

import com.timwang5.mall.pojo.Product;
import com.timwang5.mall.pojo.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author timwong5
 * @date 2022-07-23 23:32
 */
public interface ProductImageDAO extends JpaRepository<ProductImage, Integer>{
    /**
     * 通过 ProductAndTypeOrder查找Image的List
     * @param product
     * @param type
     * @return
     */
    List<ProductImage> findByProductAndTypeOrderByIdDesc(Product product, String type);
}
