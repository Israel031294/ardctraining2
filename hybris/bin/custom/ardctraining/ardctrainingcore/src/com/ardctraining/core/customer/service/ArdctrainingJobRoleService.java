package com.ardctraining.core.customer.service;

import com.ardctraining.core.model.JobRoleModel;
import java.util.List;

public interface ArdctrainingJobRoleService {

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
    JobRoleModel findByCode(String code);

}
