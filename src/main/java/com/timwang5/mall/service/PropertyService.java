package com.timwang5.mall.service;

import com.timwang5.mall.dao.PropertyDAO;
import com.timwang5.mall.pojo.Category;
import com.timwang5.mall.pojo.Property;
import com.timwang5.mall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author timwong5
 * @date 2022-07-19 15:58
 */
@Service
public class PropertyService {

    @Autowired
    PropertyDAO propertyDAO;
    @Autowired
    CategoryService categoryService;

    public void add(Property bean){
        propertyDAO.save(bean);
    }

    public void delete(int id){
        propertyDAO.delete(id);
    }

    public Property get(int id){
        //通过 id 检索实体
        return propertyDAO.findOne(id);
    }

    public void update(Property bean){
        propertyDAO.save(bean);
    }

    public Page4Navigator<Property> list(int cid, int start, int size,int navigatePages){
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);

        Page<Property> pageFromJPA = propertyDAO.findByCategory(category,pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    /**
     * 增加通过分类获取所有属性集合的方法
     * @param category
     * @return
     */
    public List<Property> listByCategory(Category category){
        return propertyDAO.findByCategory(category);
    }
}
