package getMethod;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class getWeatherTest {
    String testCity = "Rostov-on-Don";

    @Test
    public void testGetWeatherByCityName() {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/"+testCity);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);
    }

    @Test
    public void testValidateStatusCode() {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/"+testCity);
        int statusCode = response.getStatusCode();
        String statusLine = response.getStatusLine();
        System.out.println("Response status code is: " + statusCode);
        System.out.println("Response status line is: " + statusLine);
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }

    @Test
    public void testValidateCityName() {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/"+testCity);
        JsonPath jsonPathEvaluator = response.jsonPath();
        String city = jsonPathEvaluator.get("City");
        System.out.println("City received from Response is: " + city);
        Assert.assertEquals(city, testCity);
    }
}
