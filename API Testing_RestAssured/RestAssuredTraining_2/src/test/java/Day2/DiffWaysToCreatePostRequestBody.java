package Day2;

import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/**
 * @class: DiffWaysToCreatePostRequestBody
 *
 *      1.Post request body using Hashmap
 *      2.Post request creation using org.JSON
 *      3.Post request creation using POJO (Plain Old Java Object) class
 *      4.Post request using external json file data
 *
 */


public class DiffWaysToCreatePostRequestBody
{

    /**
     * @testPostUsingHashMap
     *  - Post request body using Hashmap
     * */
    //@Test(priority = 1)
    void testPostUsingHashMap()
    {
        HashMap data = new HashMap();

        data.put("name", "Scott");
        data.put("location", "France");
        data.put("phone", "123456");

        String courseArr[] = {"C", "C++"};
        data.put("courses", courseArr);

        given()
                    .contentType("application/json")
                    .body(data)
                .when()
                    .post("http://localhost:3000/students/")

                .then()
                    .statusCode(201)
                    .body("name", equalTo("Scott"))
                    .body("location", equalTo("France"))
                    .body("phone", equalTo("123456"))
                    .body("courses[0]", equalTo("C"))
                    .body("courses[1]", equalTo("C++"))
                    .header("Content-Type", "application/json; charset=utf-8")
                    .log().all();


    }

    @Test(priority = 2)
    void testDelete()
    {
            given()

                    .when()
                        .delete("http://localhost:3000/students/4")

                    .then()
                        .statusCode(200);
    }


    /**
     * @testPostUsingHashMap
     *  - Post request body using org.json
     * */
  //  @Test(priority = 1)
    void testPostUsingJSon()
    {
        JSONObject data = new JSONObject();

        data.put("name", "Scott");
        data.put("location", "France");
        data.put("phone", "123456");

        String courseArr[] = {"C", "C++"};
        data.put("courses", courseArr);


        given()
                  .contentType("application/json")
                  .body(data.toString())
                .when()
                    .post("http://localhost:3000/students/")

                .then()
                    .statusCode(201)
                    .body("name", equalTo("Scott"))
                    .body("location", equalTo("France"))
                    .body("phone", equalTo("123456"))
                    .body("courses[0]", equalTo("C"))
                    .body("courses[1]", equalTo("C++"))
                    .header("Content-Type", "application/json; charset=utf-8")
                    .log().all();
    }


    /**
     * @testPostUsingHashMap
     *  - Post request body using POJO
     * */
  //  @Test(priority = 1)
    void testPostUsingPOJO()
    {
        POJO_POSTRequest data = new POJO_POSTRequest();

        data.setName("Scott");
        data.setLocation("France");
        data.setPhone("123456");

        String courseArr[] = {"C", "C++"};
        data.setCourses(courseArr);


        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("http://localhost:3000/students/")

                .then()
                .statusCode(201)
                .body("name", equalTo("Scott"))
                .body("location", equalTo("France"))
                .body("phone", equalTo("123456"))
                .body("courses[0]", equalTo("C"))
                .body("courses[1]", equalTo("C++"))
                .header("Content-Type", "application/json; charset=utf-8")
                .log().all();
    }

    /**
     * @testPostUsingHashMap
     *  - Post request body using ExternalJSON
     *  - Use when you have data in an external file.
     *  - You could convert the data to JSON format before
     *    passing it.
     * */
    @Test(priority = 1)
    void testPostUsingExternalJSON() throws FileNotFoundException {
        File file = new File("body.json");
        FileReader fileReader = new FileReader(file);

        JSONTokener jsonTokener = new JSONTokener(fileReader);
        JSONObject data = new JSONObject(jsonTokener);




        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students/")

                .then()
                .statusCode(201)
                .body("name", equalTo("Scott"))
                .body("location", equalTo("France"))
                .body("phone", equalTo("123456"))
                .body("courses[0]", equalTo("C"))
                .body("courses[1]", equalTo("C++"))
                .header("Content-Type", "application/json; charset=utf-8")
                .log().all();
    }
}
