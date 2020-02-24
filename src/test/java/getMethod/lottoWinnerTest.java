package getMethod;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class lottoWinnerTest {
    String recordId = "2";

    @Test
    public void testGetWinners1() {
        baseURI = "http://localhost:3000/posts";

        get("/2").then().body("lotto.lottoId", equalTo(5));
        get("/2").then().body("lotto.winners.winnerId", hasItems(23, 54));
    }

    @Test
    public void testGetWinners2() {
        baseURI = "http://localhost:3000/posts";
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get("/2");
        JsonPath jsonPathEvaluator = response.jsonPath();
        int lottoId = jsonPathEvaluator.get("lotto.lottoId");
        System.out.println("Lotto ID is: " + lottoId);
        Assert.assertEquals(lottoId, 5);
    }
}
