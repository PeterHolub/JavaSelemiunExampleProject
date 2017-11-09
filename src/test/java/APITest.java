import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.core.Is.is;

public class APITest extends AssuredBase {
    private final String urlIndexUsers = "/users";

    @Test(groups = {"api"})
    public void checkUsersResponseStatusAndCountTest() {
        given()
                .when().get(urlIndexUsers)
                .then().statusCode(200).body("size()", is(10))
        ;
    }

    @Test(groups = {"api"})
    public void checkUsersResponseJsonSchema() {
        String[] rootFields = new String[]{"id", "name", "username", "email", "address", "phone", "website", "company"};
        for (String field : rootFields) {
            given()
                    .when().get(urlIndexUsers)
                    .then().body("pop()", hasKey(field))
            ;
        }

        String[] addressFields = new String[]{"street", "suite", "city", "zipcode", "geo"};
        for (String field : addressFields) {
            given()
                    .when().get(urlIndexUsers)
                    .then().body("address[0]", hasKey(field))
            ;
        }

        String[] companyFields = new String[]{"name", "catchPhrase", "bs"};
        for (String field : companyFields) {
            given()
                    .when().get(urlIndexUsers)
                    .then().body("company[0]", hasKey(field))
            ;
        }

        String[] geoFields = new String[]{"lat", "lng"};
        for (String field : geoFields) {
            given()
                    .when().get(urlIndexUsers)
                    .then().body("address.geo[0]", hasKey(field))
            ;
        }
    }
}