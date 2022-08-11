package com.timwang5.mall.dao;

import com.timwang5.mall.pojo.Order;
import com.timwang5.mall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author timwong5
 * @date 2022-07-31 22:44
 */
public interface OrderDAO extends JpaRepository<Order, Integer> {
    List<Order> findByUserAndStatusNotOrderByIdDesc(User user, String status);
}
