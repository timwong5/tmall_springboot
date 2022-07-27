package com.timwang5.mall.dao;


import com.timwang5.mall.pojo.Category;
import com.timwang5.mall.pojo.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author timwong5
 * @date 2022-07-19 15:33
 */


/**
 * 第一个参数为要操作的实体类，第二个参数为该实体类的主键类型
 * @author timwong5
 */
public interface PropertyDAO extends JpaRepository<Property, Integer> {
    /**
     * 通过Category查找分页信息
     * @param category
     * @param pageable
     * @return
     */
    Page<Property> findByCategory(Category category, Pageable pageable);

    /**
     * 通过Categories找到属性
     * @param category
     * @return
     */
    List<Property> findByCategory(Category category);
}
