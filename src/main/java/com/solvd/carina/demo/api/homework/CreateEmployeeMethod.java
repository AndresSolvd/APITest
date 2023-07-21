package com.solvd.carina.demo.api.homework;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/create", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/users/_post/rq1.json")
@ResponseTemplatePath(path = "api/users/_post/rs1.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class CreateEmployeeMethod extends AbstractApiMethodV2 {

    public CreateEmployeeMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}