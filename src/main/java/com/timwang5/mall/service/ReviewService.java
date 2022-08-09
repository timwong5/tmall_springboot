package com.timwang5.mall.service;

import com.timwang5.mall.dao.ReviewDAO;
import com.timwang5.mall.pojo.Product;
import com.timwang5.mall.pojo.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author timwong5
 * @date 2022-08-09 11:16
 */
@Service
public class ReviewService {
    @Autowired
    ReviewDAO reviewDAO;
    @Autowired
    ProductService productService;

    public void add(Review review){
        reviewDAO.save(review);
    }

    public List<Review> list(Product product){
        List<Review> reviewList = reviewDAO.findByProductOrderByIdDesc(product);
        return reviewList;
    }

    public int getCount(Product product){
        return reviewDAO.countByProduct(product);
    }
}
