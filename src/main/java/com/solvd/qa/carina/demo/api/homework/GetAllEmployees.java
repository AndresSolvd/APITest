package com.solvd.qa.carina.demo.api.homework;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/employees", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/users/_get/rsAll.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetAllEmployees extends AbstractApiMethodV2 {

    public GetAllEmployees() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
