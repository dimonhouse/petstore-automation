package framework;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.oauth2;

public class RestAssuredHelper {


    public static void setTokenRequestSpecification(String token) {
        RestAssured.authentication = oauth2(token);
    }

    public static void setup (String uri) {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(uri)
                .setContentType(ContentType.JSON)
                .build();

            RestAssured.filters(
                    //new AllureRestAssured(),
                    new RequestLoggingFilter(),
                    new ResponseLoggingFilter()
            );

    }

}
