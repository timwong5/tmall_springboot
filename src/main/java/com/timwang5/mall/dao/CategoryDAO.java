package com.timwang5.mall.dao;

import com.timwang5.mall.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author timwong5
 */
public interface CategoryDAO extends JpaRepository<Category,Integer> {
}
