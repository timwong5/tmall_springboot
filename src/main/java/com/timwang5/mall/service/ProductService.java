package com.timwang5.mall.service;

import com.timwang5.mall.dao.ProductDAO;
import com.timwang5.mall.dao.PropertyDAO;
import com.timwang5.mall.pojo.Category;
import com.timwang5.mall.pojo.Product;
import com.timwang5.mall.pojo.Property;
import com.timwang5.mall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author timwong5
 * @date 2022-07-23 0:57
 */
@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;
    @Autowired
    CategoryService categoryService;


    public void add(Product bean){
        productDAO.save(bean);
    }

    public void delete(int id){
        productDAO.delete(id);
    }

    public Product get(int id){
        //通过 id 检索实体
        return productDAO.findOne(id);
    }

    public void update(Product bean){
        productDAO.save(bean);
    }

    public Page4Navigator<Product> list(int cid, int start, int size, int navigatePages) {
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Product> pageFromJPA =productDAO.findByCategory(category,pageable);
        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }


}
