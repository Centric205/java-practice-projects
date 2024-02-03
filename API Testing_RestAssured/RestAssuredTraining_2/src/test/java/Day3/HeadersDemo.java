package Day3;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HeadersDemo {

    @Test(priority = 1)
    void testHeaders()
    {
        given()
                .when()
                    .get("https://www.google.com/")
                .then()
                // Validates header information
                    .header("Content-Type", "text/html; charset=ISO-8859-1")
                    .header("Content-Encoding", "gzip")
                    .header("Server", "gws")
                .log().all();

    }

    @Test(priority = 2)
    void getHeader()
    {
        Response response = given()
                .when()
                .get("https://www.google.com/");

        // Gets single header info
       // String headerValue = response.getHeader("Content-Type");
       // System.out.println("Value of Content-type header is: " + headerValue);

        // Gets all the Headers and their values
        Headers headers = response.getHeaders();

        System.out.println("************************************************************");
        for (Header header : headers)
        {
            System.out.println(header.getName() + ":    " + header.getValue());
        }

    }













}
