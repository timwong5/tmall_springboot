package com.timwang5.mall.controller;

import com.timwang5.mall.pojo.Property;
import com.timwang5.mall.service.PropertyService;
import com.timwang5.mall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author timwong5
 * @date 2022-07-19 16:53
 */

@RestController
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping("/categories/{cid}/properties")
    public Page4Navigator<Property> list(@PathVariable("cid") int cid, @RequestParam(value = "start",
            defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size){
        start = start<0?0:start;
        Page4Navigator<Property> page = propertyService.list(cid, start, size,5);
        return page;
    }

    @GetMapping("/properties/{id}")
    public Property get(@PathVariable("id") int id){
        Property bean = propertyService.get(id);
        return bean;
    }

    //RequestBody 把前端传来的参数自动封装到后端的JavaBean中
    @PostMapping("/properties")
    public Object add(@RequestBody Property bean){
        propertyService.add(bean);
        return bean;
    }

    //request用来取出请求信息，而response则用来添加要返回给浏览器的信息
    @DeleteMapping("/properties/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request){
        propertyService.delete(id);
        return null;
    }

    @PutMapping("/properties")
    public Object update(@RequestBody Property bean){
        propertyService.update(bean);
        return bean;
    }


}
