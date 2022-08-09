package com.timwang5.mall.dao;

import com.timwang5.mall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author timwong5
 * @date 2022-07-26 16:00
 */
public interface UserDAO extends JpaRepository<User,Integer> {
    User findByName(String name);

    User getByNameAndPassword(String name, String password);
}
