package com.timwang5.mall.controller;


import com.timwang5.mall.pojo.Category;
import com.timwang5.mall.service.CategoryService;
import com.timwang5.mall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
//    public List<Category> list() throws Exception {
//        return categoryService.list();
//    }
    public Page4Navigator<Category> list(@RequestParam(value = "start",defaultValue = "0") int start,
                                         @RequestParam(value = "size", defaultValue = "5") int size){
        start = start < 0 ? 0:start;
        //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        Page4Navigator<Category> page =categoryService.list(start, size, 5);
        return page;

    }

}
