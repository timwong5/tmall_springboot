package com.timwang5.mall.service;

import com.timwang5.mall.dao.CategoryDAO;
import com.timwang5.mall.pojo.Category;
import com.timwang5.mall.util.Page4Navigator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author timwong5
 */
@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    /**
     * 对category展示list
     * @return
     */
    public List<Category> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }


    /**
     * 选择页码的list
     * @param start
     * @param size
     * @param navigatePages
     * @return
     */
    public Page4Navigator<Category> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA = categoryDAO.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    /**
     * add
     * @param bean
     */
    public void add(Category bean) {
        categoryDAO.save(bean);
    }

    /**
     * delete
     * @param id
     */
    public void delete(int id) {
        categoryDAO.delete(id);
    }

    /**
     * get method
     * @param id
     * @return
     */
    public Category get(int id){
        Category category = categoryDAO.findOne(id);
        return category;
    }

    public void update(Category bean){
        categoryDAO.save(bean);
    }
}
