package com.timwang5.mall.comparator;

import com.timwang5.mall.pojo.Product;

import java.util.Comparator;

/**
 * ProductPriceComparator 价格比较器
 * 把 价格低的放前面
 *
 * @author timwong5
 * @date 2022-08-09 23:09
 */
public class ProductSaleCountComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return p2.getSaleCount() - p1.getSaleCount();
    }

}
