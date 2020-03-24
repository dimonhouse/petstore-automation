package framework;

import pojo.ApiResponse;
import pojo.User;

import static io.restassured.RestAssured.given;

public class UserHelper {

    public static ApiResponse postUser(User user){
        return given()
                .body(user)
                .when()
                .post("/user")
                .then()
                .statusCode(200)
                .extract().as(ApiResponse.class);

    }
}
