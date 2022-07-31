package com.timwang5.mall.dao;

import com.timwang5.mall.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author timwong5
 * @date 2022-07-31 22:44
 */
public interface OrderDAO extends JpaRepository<Order,Integer> {
}
