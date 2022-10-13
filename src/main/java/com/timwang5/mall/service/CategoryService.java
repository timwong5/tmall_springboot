package com.timwang5.mall.service;

import com.timwang5.mall.dao.CategoryDAO;
import com.timwang5.mall.pojo.Category;
import com.timwang5.mall.pojo.Product;
import com.timwang5.mall.util.Page4Navigator;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Redis的缓存都在Service层上使用
 * @author timwong5
 */
@Service
@CacheConfig(cacheNames="categories")
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;


    //key不一样，数据不再是一个对象，而是一个集合 （保存在 redis 里是一个 json 数组）
    @Cacheable(key="'categories-page-'+#p0+ '-' + #p1")
    public Page4Navigator<Category> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page pageFromJPA = categoryDAO.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA, navigatePages);
    }

    @Cacheable(key="'categories-all'")
    public List<Category> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }

    @CacheEvict(allEntries=true)
    public void add(Category bean) {
        categoryDAO.save(bean);
    }

    @CacheEvict(allEntries=true)
    public void delete(int id) {
        categoryDAO.delete(id);
    }

    @Cacheable(key="'categories-one-'+ #p0")
    public Category get(int id) {
        return categoryDAO.findOne(id);
    }

    @CacheEvict(allEntries=true)
    public void update(Category bean) {
        categoryDAO.save(bean);
    }

    public void removeCategoryFromProduct(List<Category> cs) {
        for (Category category : cs) {
            removeCategoryFromProduct(category);
        }
    }

    public void removeCategoryFromProduct(Category category) {
        List<Product> products = category.getProducts();
        if (null != products) {
            for (Product product : products) {
                product.setCategory(null);
            }
        }

        List<List<Product>> productsByRow = category.getProductsByRow();
        if (null != productsByRow) {
            for (List<Product> ps : productsByRow) {
                for (Product p : ps) {
                    p.setCategory(null);
                }
            }
        }
    }
}
