package com.timwang5.mall.dao;

import com.timwang5.mall.pojo.Product;
import com.timwang5.mall.pojo.Property;
import com.timwang5.mall.pojo.PropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author timwong5
 * @date 2022-07-26 9:49
 */
public interface PropertyValueDAO extends JpaRepository<PropertyValue, Integer> {
    /**
     * 通过产品查找属性值List
     * @param product
     * @return
     */
    List<PropertyValue> findByProductOrderByIdDesc(Product product);

    /**
     * 通过产品查找属性值
     * @param property
     * @param product
     * @return
     */
    PropertyValue getByPropertyAndProduct(Property property, Product product);
}
