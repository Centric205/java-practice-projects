package Day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class LoggingDemo {

    @Test(priority = 1)
    void testLog()
    {
        given()
                .when()
                    .get("https://www.google.com/")
                .then()
                    // You can use log to print specific data based
                    // on your needs
                    //.log().body();
                    //.log().cookies();
                    .log().headers();
    }
}














