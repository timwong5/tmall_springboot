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
    //那么要进行条件查询，就是在方法名上面做文章。
    // 比如这里的findByCategory，就是基于Category进行查询，第二个参数传一个 Pageable ， 就支持分页了

    /**
     * 通过Category查找产品的分页信息
     * @param category
     * @param pageable
     * @return
     */
    Page<Product> findByCategory(Category category, Pageable pageable);
}
