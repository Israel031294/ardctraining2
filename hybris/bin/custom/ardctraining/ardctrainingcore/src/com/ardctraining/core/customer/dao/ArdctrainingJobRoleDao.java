package com.ardctraining.core.customer.dao;

import com.ardctraining.core.model.JobRoleModel;
import java.util.List;
import java.util.Optional;

public interface ArdctrainingJobRoleDao {

    /**
     * finds all job roles
     * @return
     */
    List<JobRoleModel> findAll();

    /**
     * finds a job role by code
     * @param code
     * @return
     */
    Optional<JobRoleModel> findByCode(String code);

}
