package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * @class:UserEndPoints
 * @Purpose:
 *          - For creating CRUD (Create, Read, Update, Delete) request to the user API
 * */

public class UserEndPoints {

    // This is the implementation of creating user response
    public static Response createUser(User payload)
    {
            Response response = given()
                    // The type of Data you'll be passing
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(payload)
                .when()
                    // POST Request
                    .post(Routes.post_url);
        return response;
    }


    public static Response readUser(String username)
    {
        Response response = given()
                    .pathParam("username", username)
                .when()
                    // GET Request
                    .get(Routes.get_url);
        return response;
    }


    public static Response updateUser(String username, User payload)
    {
        Response response = given()
                    // The type of Data you'll be passing
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .pathParam("username", username)
                    .body(payload)

                .when()
                    .put(Routes.update_url);
        return response;
    }

    public static Response deleteUser(String username)
    {
        Response response = given()
                    .pathParam("username", username)
                .when()
                    // Request
                    .delete(Routes.delete_url);
        return response;
    }



}
