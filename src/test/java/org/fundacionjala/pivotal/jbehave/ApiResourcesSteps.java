package org.fundacionjala.pivotal.jbehave;

import java.util.Map;

import com.jayway.restassured.response.Response;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.fundacionjala.pivotal.api.Mapper.addResponse;
import static org.fundacionjala.pivotal.api.Mapper.mapEndpoint;
import static org.fundacionjala.pivotal.api.RequestManager.deleteRequest;
import static org.fundacionjala.pivotal.api.RequestManager.getRequest;
import static org.fundacionjala.pivotal.api.RequestManager.postRequest;
import static org.fundacionjala.pivotal.api.RequestManager.putRequest;
import static org.junit.Assert.assertEquals;

/**
 * Created by Zeus on 03/08/2016.
 */
public class ApiResourcesSteps {

    private Response response;
    private ApiResourcesSteps api;

    @When("^I send a GET request to (.*) endpoint$")
    public void iSendAGETRequest(String endPoint) {
        response = getRequest(mapEndpoint(endPoint));
    }

    @When("^I sen(?:d|t) a POST request to (.*)$")
    public void iSendAPOSTRequestWith(String endPoint, Map<String, Object> parameters) {
        response = postRequest(mapEndpoint(endPoint), parameters);
    }

    @When("^I send a PUT request to (.*?)$")
    public void iSendAPUTRequest(String endPoint, Map<String, Object> parameters) {
        response = putRequest(mapEndpoint(endPoint), parameters);
    }

    @When("^I send a DELETE request (.*?)$")
    public void iSendADELETERequest(String endPoint) {
        response = deleteRequest(mapEndpoint(endPoint));
    }

    @When("^stored as (.*)")
    public void storedAs(String key) {
        addResponse(key, response);
    }

//    Asserts

    @Then("^I expect the status code (\\d+)$")
    public void iExpectStatusCode(int statusCodeExpected) {
        assertEquals(statusCodeExpected, response.statusCode());
    }


}
