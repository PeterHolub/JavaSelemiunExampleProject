import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class APITest extends FunctionalTest {
    @Test
    public void basicPingTest() {
        given()
                .when().get("/users")
                .then().statusCode(200);
    }
}

class FunctionalTest {
    @BeforeClass
    public static void setup() {
        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "https://jsonplaceholder.typicode.com";
        }
        RestAssured.baseURI = baseHost;

    }
}

