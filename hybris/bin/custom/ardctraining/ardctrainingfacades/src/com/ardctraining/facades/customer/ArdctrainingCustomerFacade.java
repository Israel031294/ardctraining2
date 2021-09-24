package com.ardctraining.facades.customer;

import com.ardctraining.facades.customer.data.JobRoleData;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import java.util.List;

public interface ArdctrainingCustomerFacade extends CustomerFacade {

    /**
     * gets all job roles
     * @return
     */
    List<JobRoleData> getJobRoles();

}
