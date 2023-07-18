package com.solvd.qa.carina.demo;

import com.solvd.qa.carina.demo.api.DeleteUserMethod;
import com.solvd.qa.carina.demo.api.GetUserMethods;
import com.solvd.qa.carina.demo.api.homework.*;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class ApiTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetEmployee() throws Exception {
        GetEmployee getEmployee = new GetEmployee();
        getEmployee.callAPIExpectSuccess();
        getEmployee.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetAllEmployees() throws Exception {
        GetAllEmployees getAllEmployees = new GetAllEmployees();
        getAllEmployees.callAPIExpectSuccess();
        getAllEmployees.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateEmployee() throws Exception {
        // Preparing request
        CreateEmployee api = new CreateEmployee();
        api.setProperties("api/users/user.properties");

        // Making call to endpoint
        api.callAPIExpectSuccess();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testUpdateEmployee() throws Exception {
        // Preparing request
        UpdateEmployee api = new UpdateEmployee();
        api.setProperties("api/users/user.properties");

        // Making call to endpoint
        api.callAPIExpectSuccess();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void DeleteEmployee() {
        DeleteEmployee deleteEmployee = new DeleteEmployee();
        deleteEmployee.setProperties("api/users/user.properties");
        deleteEmployee.callAPIExpectSuccess();
    }
}