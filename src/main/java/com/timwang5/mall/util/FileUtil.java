package com.timwang5.mall.util;

import com.timwang5.mall.pojo.ProductImage;
import com.timwang5.mall.service.ProductImageService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @author timwong5
 * @date 2022-07-25 16:17
 */
public class FileUtil {

    public static File createImgFile(ProductImage bean, String folder, HttpServletRequest request){
        if(ProductImageService.type_single.equals(bean.getType())){
            folder +="productSingle";
        }
        else{
            folder +="productDetail";
        }

        File imageFolder= new File(request.getServletContext().getRealPath(folder));
        File file = new File(imageFolder,bean.getId()+".jpg");
        return file;
    }

}
