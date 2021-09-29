package com.ardctraining.facades.product;

import com.ardctraining.facades.product.data.CustomProductLabelData;
import de.hybris.platform.commercefacades.product.ProductFacade;
import java.util.List;

public interface ArdctrainingProductFacade extends ProductFacade {

    /**
     * gets custom labels by product
     * @param product
     * @return
     */
    List<CustomProductLabelData> getCustomLabels(final String product);

}
