package com.ardctraining.storefront.form.validator;

import com.ardctraining.storefront.form.ArdctrainingRegisterForm;
import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.RegistrationValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component("ardctrainingRegisterValidator")
public class ArdctrainingRegisterFormValidator extends RegistrationValidator {

    @Override
    public void validate(final Object object, final Errors errors) {
        super.validate(object, errors);

        final ArdctrainingRegisterForm form = (ArdctrainingRegisterForm) object;

        validateCompany(form.getCompany(), errors);
        validateJobRole(form.getJobRole(), errors);
    }

    private void validateCompany(final String company, final Errors errors) {
        if (StringUtils.isEmpty(company)) {
            errors.rejectValue("company", "register.company.invalid");
        }
    }

    private void validateJobRole(final String jobRole, final Errors errors) {
        if (StringUtils.isEmpty(jobRole)) {
            errors.rejectValue("jobRole", "register.jobRole.invalid");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return ArdctrainingRegisterForm.class.equals(aClass);
    }
}
