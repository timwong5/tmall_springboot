package com.timwang5.mall.dao;


import com.timwang5.mall.pojo.Category;
import com.timwang5.mall.pojo.Product;
import com.timwang5.mall.pojo.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author timwong5
 * @date 2022-07-19 15:33
 */


//第一个参数为要操作的实体类，第二个参数为该实体类的主键类型
public interface PropertyDAO extends JpaRepository<Property, Integer> {
    Page<Property> findByCategory(Category category, Pageable pageable);
}
