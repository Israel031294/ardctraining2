package com.ardctraining.storefront.form;

import de.hybris.platform.acceleratorstorefrontcommons.forms.RegisterForm;

public class ArdctrainingRegisterForm extends RegisterForm {

    private String company;
    private String jobRole;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }
}
