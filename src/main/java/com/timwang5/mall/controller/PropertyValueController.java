package com.timwang5.mall.controller;

import com.timwang5.mall.pojo.Product;
import com.timwang5.mall.pojo.PropertyValue;
import com.timwang5.mall.service.ProductService;
import com.timwang5.mall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author timwong5
 * @date 2022-07-26 14:11
 */
@RestController
public class PropertyValueController {
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    ProductService productService;


    @GetMapping("/products/{pid}/propertyValues")
    public List<PropertyValue> list(@PathVariable("pid") int pid) throws Exception {
        Product product = productService.get(pid);
        if (product == null){
            throw new RuntimeException("error in product");
        }
        propertyValueService.init(product);
        List<PropertyValue> propertyValues = propertyValueService.list(product);
        return propertyValues;
    }

    @PutMapping("/propertyValues")
    public Object update(@RequestBody PropertyValue bean) throws Exception {
        propertyValueService.update(bean);
        return bean;
    }

}
