package Day4;

import com.beust.ah.A;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/**
 * @ParsingJSONResponse
 * @Objective:
 *          - Validating the JSON Response
 *
 * */
public class ParsingJSONResponse {

    @Test(priority = 1)
    void testJSONResponse()
    {
        // First Approach
        /**
        given()
                    .contentType("ContentType.JSON")
                .when()
                    .get("http://localhost:3000/store")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("book[3].title", equalTo("The Lord of the Rings"));
         */

        // Second Approach [Recommended], why?
        // It gives you the flexibility to manipulate data to your liking
        Response response = given()
                            .contentType("ContentType.JSON")
                .when()
                            .get("http://localhost:3000/store");

        Assert.assertEquals(response.getStatusCode(), 200); // Validation 1
        Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");

        String bookname = response.jsonPath().getString("book[3].title").toString();
        Assert.assertEquals(bookname, "The Lord of the Rings");

    }

    @Test(priority = 2)
    void testJSONResponseBody()
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/store");

        // Using JSON Object class
        JSONObject jsonObject = new JSONObject(response.asString());

        // Print all tittles of books
        for (int index = 0; index < jsonObject.getJSONArray("book").length(); index++)
        {
            String bookTitle = jsonObject.getJSONArray("book").getJSONObject(index).get("title").toString();
            System.out.println(bookTitle);
        }

        // Checks if said book exists
        boolean status = false;
        for (int index = 0; index < jsonObject.getJSONArray("book").length(); index++)
        {
            String bookTitle = jsonObject.getJSONArray("book").getJSONObject(index).get("title").toString();

            if (bookTitle.equals("The Lord of the Rings"))
            {
                status = true;
                break;
            }
        }

        Assert.assertEquals(status, true);

        // Validate total price of books
        double totalPrice = 0;
        for (int index = 0; index < jsonObject.getJSONArray("book").length(); index++)
        {
            String price = jsonObject.getJSONArray("book").getJSONObject(index).get("price").toString();
            totalPrice = totalPrice + Double.parseDouble(price);
        }

        System.out.println("Total price of books is: " + totalPrice);
        Assert.assertEquals(totalPrice, 53.92);

        /**
         * You now have an idea. The rest you can figure out. You need to
         * understand JSON format properly.
         *
         * */
    }
}



























