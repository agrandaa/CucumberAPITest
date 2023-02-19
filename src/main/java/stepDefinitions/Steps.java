package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class Steps {
    private static Response response;

    @When("I send GET request with successful data")
    public void i_send_get_request_with_successful_data() {
            response = RestAssured.given()
                .header("apikey", "23W5LiOqyGr4zlIAZuMmojn2SFesydiM")
                .when()
                .get("https://api.apilayer.com/exchangerates_data/latest")
                .then()
                .extract().response();
    }

    @When("I send GET request with wrong request data")
    public void i_send_get_request_with_wrong_request_data() {
        response = RestAssured.given()
                .header("apikey", "23W5LiOqyGr4zlIAZuMmojn2SFesydiM")
                .when()
                .get("https://api.apilayer.com/exchangerates_data/latestxxxxxx")
                .then()
                .extract().response();
    }

    @When("I send GET request but I am unauthorized to get response data")
    public void i_send_get_request_but_i_am_unauthorized_to_get_response_data() {
        response = RestAssured.given()
                .header("apikey", "bad key")
                .when()
                .get("https://api.apilayer.com/exchangerates_data/latest")
                .then()
                .extract().response();
    }

    @When("I send GET request but the endpoint is forbidden to me")
    public void i_send_get_request_but_the_endpoint_is_forbidden_to_me() {
        response = RestAssured.given()
                .header("apikey", "23W5LiOqyGr4zlIAZuMmojn2SFesydiM")
                .when()
                .get("https://api.apilayer.com/number_verification/countries")
                .then()
                .extract().response();
    }

    @When("I send GET request but the endpoint is not found")
    public void i_send_get_request_but_the_endpoint_is_not_found() {
        response = RestAssured.given()
                .header("apikey", "23W5LiOqyGr4zlIAZuMmojn2SFesydiM")
                .when()
                .get("https://api.apilayer.com/exchangerates_dataaaa/latest")
                .then()
                .extract().response();
    }

    @Then("the response has a {int} response code")
    public void the_response_has_a_response_code(int code) {
        Assert.assertEquals(code, response.getStatusCode());
    }
}
