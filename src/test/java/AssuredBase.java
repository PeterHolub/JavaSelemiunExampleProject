import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class AssuredBase {
    @BeforeClass
    public static void setup() {
        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "https://jsonplaceholder.typicode.com";
        }
        RestAssured.baseURI = baseHost;
    }
}
