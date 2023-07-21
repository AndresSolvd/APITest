package com.solvd.carina.demo;

import com.solvd.carina.demo.api.homework.*;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class ApiTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetEmployeeMethod() throws Exception {
        GetEmployeeMethod getEmployeeMethod = new GetEmployeeMethod();
        getEmployeeMethod.callAPIExpectSuccess();
        getEmployeeMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetAllEmployeesMethod() throws Exception {
        GetAllEmployeesMethod getAllEmployeesMethod = new GetAllEmployeesMethod();
        getAllEmployeesMethod.callAPIExpectSuccess();
        getAllEmployeesMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateEmployeeMethod() throws Exception {
        // Preparing request
        CreateEmployeeMethod api = new CreateEmployeeMethod();
        api.setProperties("api/users/user.properties");

        // Making call to endpoint
        api.callAPIExpectSuccess();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testUpdateEmployeeMethod() throws Exception {
        // Preparing request
        UpdateEmployeeMethod api = new UpdateEmployeeMethod();
        api.setProperties("api/users/user.properties");

        // Making call to endpoint
        api.callAPIExpectSuccess();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void DeleteEmployeeMethod() {
        DeleteEmployeeMethod deleteEmployeeMethod = new DeleteEmployeeMethod();
        deleteEmployeeMethod.setProperties("api/users/user.properties");
        deleteEmployeeMethod.callAPIExpectSuccess();
    }
}