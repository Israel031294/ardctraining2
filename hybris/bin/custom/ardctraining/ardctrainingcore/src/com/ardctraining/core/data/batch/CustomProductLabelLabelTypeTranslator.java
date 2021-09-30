package com.ardctraining.core.data.batch;

import com.ardctraining.core.enums.CustomLabelTypeEnum;
import de.hybris.platform.core.Registry;
import de.hybris.platform.enumeration.EnumerationService;
import de.hybris.platform.impex.jalo.header.StandardColumnDescriptor;
import de.hybris.platform.impex.jalo.translators.AbstractValueTranslator;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.JaloInvalidParameterException;

public class CustomProductLabelLabelTypeTranslator extends AbstractValueTranslator {

    private EnumerationService enumerationService;

    private static final String ENUMERATION_SERVICE_BEAN = "enumerationService";

    @Override
    public void init(StandardColumnDescriptor descriptor) {
        super.init(descriptor);

        enumerationService = Registry.getApplicationContext().getBean(ENUMERATION_SERVICE_BEAN, EnumerationService.class);
    }

    @Override
    public Object importValue(final String s, final Item item) throws JaloInvalidParameterException {
        clearStatus();

        CustomLabelTypeEnum result;

        switch(s) {
            case "P": result = CustomLabelTypeEnum.PRIMARY; break;
            case "S": result = CustomLabelTypeEnum.SECONDARY; break;
            case "A": result = CustomLabelTypeEnum.ALTERNATIVE; break;
            default:
                result = getEnumerationService().getEnumerationValue(CustomLabelTypeEnum.class, s);
        }

        return result;
    }

    @Override
    public String exportValue(Object o) throws JaloInvalidParameterException {
        return null;
    }

    public EnumerationService getEnumerationService() {
        return enumerationService;
    }
}
