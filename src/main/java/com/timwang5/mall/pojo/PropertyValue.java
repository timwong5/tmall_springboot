package com.timwang5.mall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @author timwong5
 * @date 2022-07-25 22:58
 */
@Entity
@Table(name = "propertyvalue")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class PropertyValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "pid")

    private Product product;
    @ManyToOne

    @JoinColumn(name = "ptid")
    private Property property;

    private String value;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "PropertyValue [id=" + id + ", product=" + product + ", property=" + property + ", value=" + value + "]";
    }
}
