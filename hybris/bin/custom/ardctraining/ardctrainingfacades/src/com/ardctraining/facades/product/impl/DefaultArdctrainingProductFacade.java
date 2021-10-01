package com.ardctraining.facades.product.impl;

import com.ardctraining.core.model.CustomProductLabelModel;
import com.ardctraining.core.product.service.CustomProductLabelService;
import com.ardctraining.facades.product.ArdctrainingProductFacade;
import com.ardctraining.facades.product.data.CustomProductLabelData;
import de.hybris.platform.commercefacades.product.impl.DefaultProductFacade;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.apache.log4j.Logger;

public class DefaultArdctrainingProductFacade extends DefaultProductFacade implements ArdctrainingProductFacade {

    private CustomProductLabelService customProductLabelService;
    private Converter<CustomProductLabelModel, CustomProductLabelData> customProductLabelConverter;

    private static final Logger LOG = Logger.getLogger(DefaultArdctrainingProductFacade.class);

    @Override
    public List<CustomProductLabelData> getCustomLabels(final String productCode) {
        try {
            final ProductModel product = getProductService().getProductForCode(productCode);
            final UserModel user = getUserService().getCurrentUser();

            if (Objects.nonNull(user) && user instanceof CustomerModel) {
                final CustomerModel customer = (CustomerModel) user;
                final List<CustomProductLabelModel> labels = getCustomProductLabelService().findByCustomerAndProduct(customer, product);

                return getCustomProductLabelConverter().convertAll(labels);
            } else {
                LOG.error(String.format("unable to get custom labels with current user %s", user.getUid()));
            }

        } catch(final UnknownIdentifierException | AmbiguousIdentifierException ex) {
            LOG.error(String.format("unable to find product with code %s", productCode), ex);
        }

        return Collections.emptyList();
    }

    @Override
    public List<CustomProductLabelData> getCustomLabelsByCustomerAndProduct(final String customerId, final String productCode) {
        final CustomerModel user = getUserService().getUserForUID(customerId, CustomerModel.class);
        final ProductModel product = getProductService().getProductForCode(productCode);

        return getCustomProductLabelConverter().convertAll(getCustomProductLabelService().findByCustomerAndProduct(user, product));
    }

    public CustomProductLabelService getCustomProductLabelService() {
        return customProductLabelService;
    }

    public void setCustomProductLabelService(CustomProductLabelService customProductLabelService) {
        this.customProductLabelService = customProductLabelService;
    }

    public Converter<CustomProductLabelModel, CustomProductLabelData> getCustomProductLabelConverter() {
        return customProductLabelConverter;
    }

    public void setCustomProductLabelConverter(Converter<CustomProductLabelModel, CustomProductLabelData> customProductLabelConverter) {
        this.customProductLabelConverter = customProductLabelConverter;
    }
}
