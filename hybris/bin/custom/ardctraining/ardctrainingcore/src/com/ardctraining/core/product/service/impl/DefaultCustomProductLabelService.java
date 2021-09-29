package com.ardctraining.core.product.service.impl;

import com.ardctraining.core.model.CustomProductLabelModel;
import com.ardctraining.core.product.dao.CustomProductLabelDao;
import com.ardctraining.core.product.service.CustomProductLabelService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.util.ServicesUtil;
import java.util.List;

public class DefaultCustomProductLabelService implements CustomProductLabelService {

    private CustomProductLabelDao customProductLabelDao;

    @Override
    public List<CustomProductLabelModel> findByCustomerAndProduct(final CustomerModel customer, final ProductModel product) {
        ServicesUtil.validateParameterNotNull(customer, "customer cannot be null");
        ServicesUtil.validateParameterNotNull(product, "product cannot be null");

        return getCustomProductLabelDao().findByCustomerAndProduct(customer, product);
    }

    public CustomProductLabelDao getCustomProductLabelDao() {
        return customProductLabelDao;
    }

    public void setCustomProductLabelDao(CustomProductLabelDao customProductLabelDao) {
        this.customProductLabelDao = customProductLabelDao;
    }
}
