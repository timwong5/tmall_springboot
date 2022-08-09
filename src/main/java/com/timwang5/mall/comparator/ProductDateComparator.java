package com.timwang5.mall.comparator;

import com.timwang5.mall.pojo.Product;

import java.util.Comparator;

/**
 * ProductDateComparator 新品比较器
 * 把 创建日期晚的放前面
 *
 * @author timwong5
 * @date 2022-08-09 23:06
 */
public class ProductDateComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return p1.getCreateDate().compareTo(p2.getCreateDate());
    }

}