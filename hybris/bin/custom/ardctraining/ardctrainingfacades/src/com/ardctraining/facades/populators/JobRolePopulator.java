package com.ardctraining.facades.populators;

import com.ardctraining.core.model.JobRoleModel;
import com.ardctraining.facades.customer.data.JobRoleData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

public class JobRolePopulator implements Populator<JobRoleModel, JobRoleData> {

    @Override
    public void populate(final JobRoleModel source, final JobRoleData target) throws ConversionException {
        target.setCode(source.getCode());
        target.setName(source.getDescription());
    }
}
