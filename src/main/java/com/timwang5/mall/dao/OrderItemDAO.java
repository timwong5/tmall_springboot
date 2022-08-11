package com.timwang5.mall.dao;

import com.timwang5.mall.pojo.Order;
import com.timwang5.mall.pojo.OrderItem;
import com.timwang5.mall.pojo.Product;
import com.timwang5.mall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author timwong5
 * @date 2022-07-31 22:43
 */
public interface OrderItemDAO extends JpaRepository<OrderItem,Integer> {
    List<OrderItem> findByOrderOrderByIdDesc(Order order);
    List<OrderItem> findByProduct(Product product);
    List<OrderItem> findByUserAndOrderIsNull(User user);
}
