package com.timwang5.mall.controller;


import com.timwang5.mall.pojo.Category;
import com.timwang5.mall.service.CategoryService;
import com.timwang5.mall.util.ImageUtil;
import com.timwang5.mall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * @author timwong5
 */
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * 通过get请求页码的list
     * @param start
     * @param size
     * @return
     */
    @GetMapping("/categories")
    public Page4Navigator<Category> list(@RequestParam(value = "start",defaultValue = "0") int start,
                                         @RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
        start = start < 0 ? 0:start;
        //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        Page4Navigator<Category> page =categoryService.list(start, size, 5);
        return page;

    }

    @PostMapping("/categories")
    public Object add(Category bean, MultipartFile image, HttpServletRequest request) throws IOException {
        categoryService.add(bean);
        saveOrUpdateImageFile(bean, image, request);
        return bean;
    }

    /**
     * 保存和上传图片
     * @param bean
     * @param image
     * @param request
     * @throws IOException
     */
    private void saveOrUpdateImageFile(Category bean, MultipartFile image, HttpServletRequest request) throws IOException {
        File imageFolder = new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,bean.getId()+".jpg");
        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    /**
     * 删除
     * @param id
     * @param request
     * @return
     */
    @DeleteMapping("/categories/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request) throws Exception{
        categoryService.delete(id);
        File imageFolder = new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
        return null;

    }

    /**
     * 根据id获取bean
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/categories/{id}")
    public Category get(@PathVariable("id") int id) throws Exception {
        Category bean = categoryService.get(id);
        return bean;
    }

    /**
     * update
     * @param bean
     * @param image
     * @param request
     * @return
     * @throws Exception
     */
    @PutMapping("/categories/{id}")
    public Object update(Category bean, MultipartFile image,HttpServletRequest request) throws Exception {
        String name = request.getParameter("name");
        bean.setName(name);
        categoryService.update(bean);

        if(image!=null) {
            saveOrUpdateImageFile(bean, image, request);
        }
        return bean;
    }

}
