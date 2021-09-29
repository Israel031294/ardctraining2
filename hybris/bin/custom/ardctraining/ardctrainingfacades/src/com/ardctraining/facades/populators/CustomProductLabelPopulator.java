package com.ardctraining.facades.populators;

import com.ardctraining.core.model.CustomProductLabelModel;
import com.ardctraining.facades.product.data.CustomProductLabelData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

public class CustomProductLabelPopulator implements Populator<CustomProductLabelModel, CustomProductLabelData> {

    @Override
    public void populate(final CustomProductLabelModel source, final CustomProductLabelData target) throws ConversionException {
        target.setType(source.getLabelType().getCode().toLowerCase());
        target.setLabel(source.getLabel());
    }
}
