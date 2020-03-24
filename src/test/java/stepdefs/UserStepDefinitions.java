package stepdefs;

import framework.RestAssuredHelper;
import framework.UserHelper;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.testng.asserts.SoftAssert;
import pojo.ApiResponse;
import pojo.User;

public class UserStepDefinitions {
    private User user;
    private ApiResponse response;

    @Given("I want to create user with {int} id, {string} username, {string} firstName, {string} lastName, {string} password, {string} email, {string} phone, {int} status")
    public void prepareUser(Integer id, String username, String firstName, String lastName, String password, String email, String phone, Integer status){
        user = User.builder().username(username).id(id)
                .userStatus(status).email(email).firstName(firstName).lastName(lastName).password(password).phone(phone).build();
    }

    @When("I create new user")
    public void createUser(){
        response = UserHelper.postUser(user);
    }

    @Then("User is created")
    public void checkResponse(){
        SoftAssert softAssert = new SoftAssert();
        Integer expResp = 200;
        softAssert.assertEquals(response.getCode(), 200);
        softAssert.assertEquals(response.getType(), "unknown");
        softAssert.assertAll();
    }
    @Before()
    public void setup(){
        RestAssuredHelper.setup("https://petstore.swagger.io/v2");
        System.out.println("Before invoked");
    }


}
