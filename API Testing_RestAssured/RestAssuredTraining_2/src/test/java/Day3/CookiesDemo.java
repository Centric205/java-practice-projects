package Day3;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CookiesDemo {

 //   @Test(priority = 1)
    void testCookies()
    {
        given()

                .when()
                .get("https://www.google.com/")

                .then()
                // It will fail because Cookie values change with each run
                //.cookies("AEC", "AEC=AUEFqZeWtIneAtg3-86DFjjMA1awqg8z232PsGBovcdLKo5cpHPrVIHhjA")
                .log().all();
    }

    @Test(priority = 2)
    void getCookiesInfo()
    {
        Response res = given()
                .when()
                    .get("https://www.google.com/");

        // Get single cookie info
        // Name of cookie does not change, but it's value does
        //String cookie_value = res.getCookie("AEC");
        //System.out.println("Value of cookie is=====>" + cookie_value);

        // Retrieves all the available cookies  from the URL
        Map<String, String> cookie_values = res.getCookies();

        for (String key : cookie_values.keySet()) {
            // Using Map method to print cookies values
            //System.out.println(key + ": " + cookie_values.get(key));

            // Using the getCookie method
            System.out.println(key + ": " + res.getCookie(key));
        }
    }

}
