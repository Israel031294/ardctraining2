package com.ardctraining.core.product.service.impl;

import com.ardctraining.core.model.CustomProductLabelModel;
import com.ardctraining.core.product.dao.CustomProductLabelDao;
import com.ardctraining.core.product.service.CustomProductLabelService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.time.TimeService;
import de.hybris.platform.servicelayer.util.ServicesUtil;
import java.util.Date;
import java.util.List;

public class DefaultCustomProductLabelService implements CustomProductLabelService {

    private CustomProductLabelDao customProductLabelDao;
    private TimeService timeService;

    @Override
    public List<CustomProductLabelModel> findByCustomerAndProduct(final CustomerModel customer, final ProductModel product) {
        ServicesUtil.validateParameterNotNull(customer, "customer cannot be null");
        ServicesUtil.validateParameterNotNull(product, "product cannot be null");

        return getCustomProductLabelDao().findByCustomerAndProduct(customer, product);
    }

    @Override
    public List<CustomProductLabelModel> findExpired() {
        final Date now = getTimeService().getCurrentTime();

        return getCustomProductLabelDao().findExpired(now);
    }

    public CustomProductLabelDao getCustomProductLabelDao() {
        return customProductLabelDao;
    }

    public void setCustomProductLabelDao(CustomProductLabelDao customProductLabelDao) {
        this.customProductLabelDao = customProductLabelDao;
    }

    public TimeService getTimeService() {
        return timeService;
    }

    public void setTimeService(TimeService timeService) {
        this.timeService = timeService;
    }
}
