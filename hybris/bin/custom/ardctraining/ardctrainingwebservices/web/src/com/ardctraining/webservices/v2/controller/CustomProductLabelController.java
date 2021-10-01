package com.ardctraining.webservices.v2.controller;

import com.ardctraining.product.dto.search.CustomProductLabelSearchWsDTO;
import com.ardctraining.webservices.v2.helper.ProductsHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import de.hybris.platform.webservicescommons.swagger.ApiBaseSiteIdParam;
import de.hybris.platform.webservicescommons.swagger.ApiFieldsParam;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "CustomLabels")
@RequestMapping(value = "/{baseSiteId}/labels")
public class CustomProductLabelController extends BaseController {

    @Resource
    private ProductsHelper productsHelper;

    @GetMapping(value = "/{customerId}/{productCode}")
    @ResponseBody
    @ApiOperation(nickname = "getCustomLabels", value = "Get a list of custom labels based on customer and product")
    @ApiBaseSiteIdParam
    public List<CustomProductLabelSearchWsDTO> getCustomLabels(
            @ApiParam(value = "customer identifier", required = true) @PathVariable final String customerId,
            @ApiParam(value = "product code", required = true) @PathVariable final String productCode,
            @ApiFieldsParam @RequestParam(defaultValue = DEFAULT_FIELD_SET) final String fields,
            final HttpServletResponse response) {
        return productsHelper.searchCustomLabels(customerId, productCode, fields);
    }

}
