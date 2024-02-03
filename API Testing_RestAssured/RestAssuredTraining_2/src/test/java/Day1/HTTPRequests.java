package Day1;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//import static io.restassured.RestAssured.given;

public class HTTPRequests {

    int id;

    @Test(priority = 1)
     void getUsers()
    {
        given()
                .when()
                    .get("https://reqres.in/api/users?page=2")

                .then()
                    .statusCode(200)
                    .body("page", equalTo(2))
                    .log().all();
    }


    @Test(priority = 2)
    void createUser()
    {
        HashMap data = new HashMap<>();
        data.put("name", "paven");
        data.put("job", "trainer");

        id=given()
                    .contentType("application/json")
                    .body(data)
                .when()
                    .post("https://reqres.in/api/users")
                    .jsonPath().getInt("id");

                // Performs validation
                //.then()
                  //  .statusCode(201)
                    // Logs all the data into console
                  //  .log().all();
    }

    /**
     * @dependsOnMethods
     *      - checks to see if the "createUser" method has been called.
     *      - if not, then it won't be executed.
     * @Reason
     *      - it needs the "id" variable in the post() method
     *
     * */
    @Test(priority = 3, dependsOnMethods = ("createUser"))
    void updateUser()
    {
        HashMap data = new HashMap<>();
        data.put("name", "john");
        data.put("job", "teacher");

        given()
                    .contentType("application/json")
                    .body(data)
                .when()
                    .put("https://reqres.in/api/users/"+id)

                .then()
                    .statusCode(200)
                    .log().all();
    }

    @Test(priority = 4)
    void deleteUser()
    {
        given()

                .when()
                    .delete("https://reqres.in/api/users/"+id)

                .then()
                    .statusCode(204)
                    .log().all();
    }
}
