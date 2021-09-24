package com.ardctraining.core.customer.dao.impl;

import com.ardctraining.core.customer.dao.ArdctrainingJobRoleDao;
import com.ardctraining.core.model.JobRoleModel;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.collections4.CollectionUtils;

public class DefaultArdctrainingJobRoleDao extends DefaultGenericDao<JobRoleModel> implements ArdctrainingJobRoleDao {

    public DefaultArdctrainingJobRoleDao() {
        super(JobRoleModel._TYPECODE);
    }

    @Override
    public List<JobRoleModel> findAll() {
        return this.find();
    }

    @Override
    public Optional<JobRoleModel> findByCode(final String code) {
        final Map<String, Object> params = Collections.singletonMap(JobRoleModel.CODE, code);
        final List<JobRoleModel> result = this.find(params);

        if (CollectionUtils.isNotEmpty(result)) {
            return Optional.of(result.get(0));
        }

        return Optional.empty();
    }
}
