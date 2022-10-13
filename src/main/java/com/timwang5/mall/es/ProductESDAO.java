package com.timwang5.mall.es;

import com.timwang5.mall.pojo.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author timwong5
 * @date 2022-10-13 19:54
 */
public interface ProductESDAO extends ElasticsearchRepository<Product,Integer> {
}
