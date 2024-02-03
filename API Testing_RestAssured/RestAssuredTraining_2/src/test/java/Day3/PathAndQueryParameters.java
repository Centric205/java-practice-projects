package Day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class PathAndQueryParameters {

    @Test
    void testQueryAndPathParameters()
    {
        given()
                /**
                 * | Q | What is the difference between Path-parameter and Query-parameter?
                 * ans: Path-parameters are like variables whereas query-parameters go with
                 *      the request
                 * */
                    .pathParam("mypath", "users") // path parameters
                    .queryParam("page", 2) // query parameter
                    .queryParam("id", 5) // query parameter
                .when()
                    .get("https://reqres.in/api/{mypath}")
                .then()
                    .statusCode(200)
                    .log().all();
    }
}
