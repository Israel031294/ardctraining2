package com.ardctraining.core.product.dao;

import com.ardctraining.core.model.CustomProductLabelModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import java.util.Date;
import java.util.List;

public interface CustomProductLabelDao {

    /**
     * finds a custom label by customer and product
     * @param customer
     * @param product
     * @return
     */
    List<CustomProductLabelModel> findByCustomerAndProduct(CustomerModel customer, ProductModel product);

    /**
     * finds all expired labels
     * @param now
     * @return
     */
    List<CustomProductLabelModel> findExpired(Date now);

}
