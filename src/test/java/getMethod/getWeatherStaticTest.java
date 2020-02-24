package getMethod;

import static io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class getWeatherStaticTest {
    String testCity = "Rostov-on-Don";

    @Test
    public void testGetWeatherByCityName1() {
        baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = given();
        Response response = httpRequest.request(Method.GET, "/"+testCity);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);
    }

    @Test
    public void testGetWeatherByCityName2() {
             given()
                .baseUri("http://restapi.demoqa.com/utilities/weather/city")
                .when()
                .get("/"+testCity)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
