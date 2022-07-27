package com.timwang5.mall.service;

import com.timwang5.mall.dao.PropertyValueDAO;
import com.timwang5.mall.pojo.Product;
import com.timwang5.mall.pojo.Property;
import com.timwang5.mall.pojo.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author timwong5
 * @date 2022-07-26 13:41
 */
@Service
public class PropertyValueService {
    @Autowired
    PropertyValueDAO propertyValueDAO;
    @Autowired
    PropertyService propertyService;

    public void update(PropertyValue bean){
        propertyValueDAO.save(bean);
    }

    public void init(Product product){
        List<Property> properties = propertyService.listByCategory(product.getCategory());
        if (properties != null) {
            for (Property property : properties) {
                PropertyValue propertyValue = getByPropertyAndProduct(product, property);
                if (propertyValue == null) {
                    propertyValue = new PropertyValue();
                    propertyValue.setProduct(product);
                    propertyValue.setProperty(property);
                    propertyValueDAO.save(propertyValue);
                }
            }
        }
        else {
            throw new RuntimeException("properties is null");
        }
    }

    public PropertyValue getByPropertyAndProduct(Product product, Property property) {
        return propertyValueDAO.getByPropertyAndProduct(property,product);
    }

    public List<PropertyValue> list(Product product) {
        return propertyValueDAO.findByProductOrderByIdDesc(product);
    }
}
