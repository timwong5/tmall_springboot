package com.timwang5.mall.comparator;

import com.timwang5.mall.pojo.Product;

import java.util.Comparator;

/**
 * ProductAllComparator 综合比较器
 * 把 销量x评价 高的放前面
 *
 * @author timwong5
 * @date 2022-08-09 21:31
 */
public class ProductAllComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p2.getReviewCount() * p2.getSaleCount() - p1.getReviewCount() * p1.getSaleCount();
    }
}
