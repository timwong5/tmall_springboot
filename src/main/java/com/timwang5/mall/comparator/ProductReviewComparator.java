package com.timwang5.mall.comparator;

import com.timwang5.mall.pojo.Product;

import java.util.Comparator;

/**
 * ProductReviewComparator 人气比较器
 * 把 评价数量多的放前面
 *
 * @author timwong5
 * @date 2022-08-09 23:07
 */
public class ProductReviewComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return p2.getReviewCount() - p1.getReviewCount();
    }

}
