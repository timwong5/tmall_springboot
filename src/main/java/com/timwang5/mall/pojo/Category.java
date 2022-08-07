package com.timwang5.mall.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * @author timwong5
 */
@Entity
@Table(name = "category")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Category {
    //主键自增
    @Id
    // -IDENTITY 主键由数据库生成, 采用数据库自增长, Oracle不支持这种方式
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column注解用来标识实体类中属性与数据表中字段的对应关系
    @Column(name = "id")
    int id;

    @Transient
    List<Product> products;
    @Transient
    List<List<Product>> productsByRow;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<List<Product>> getProductsByRow() {
        return productsByRow;
    }

    public void setProductsByRow(List<List<Product>> productsByRow) {
        this.productsByRow = productsByRow;
    }

    String name;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
