package com.ardctraining.core.customer.service.impl;

import com.ardctraining.core.customer.dao.ArdctrainingJobRoleDao;
import com.ardctraining.core.customer.service.ArdctrainingJobRoleService;
import com.ardctraining.core.model.JobRoleModel;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.util.ServicesUtil;
import java.util.List;
import java.util.Optional;

public class DefaultArdctrainingJobRoleService implements ArdctrainingJobRoleService {

    private ArdctrainingJobRoleDao ardctrainingJobRoleDao;

    @Override
    public List<JobRoleModel> findAll() {
        return getArdctrainingJobRoleDao().findAll();
    }

    @Override
    public JobRoleModel findByCode(final String code) {
        ServicesUtil.validateParameterNotNull(code, "code cannot be null");

        final Optional<JobRoleModel> result = getArdctrainingJobRoleDao().findByCode(code);

        if (result.isEmpty()) {
            throw new UnknownIdentifierException(String.format("unable to find job role with code %s", code));
        }

        return result.get();
    }

    public ArdctrainingJobRoleDao getArdctrainingJobRoleDao() {
        return ardctrainingJobRoleDao;
    }

    public void setArdctrainingJobRoleDao(ArdctrainingJobRoleDao ardctrainingJobRoleDao) {
        this.ardctrainingJobRoleDao = ardctrainingJobRoleDao;
    }
}
