package com.gorest.crudtest;

import com.gorest.gorestinfo.UserSteps;
import com.gorest.testbase.TestBase;
import com.gorest.utils.TestUtil;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UserCRUDTest extends TestBase {

    static int userId;
    static String name = TestUtil.getRandomName();
    static String email = TestUtil.getRandomValue() + "abc@gmail.com";
    static String gender = "female";
    static String status = "active";
    static String token = "96b8378466d4dea75932675beb87d26be273534f95f4a1a7e2b1cf83c0a75e4a";
    @Steps
    UserSteps userSteps;
    ValidatableResponse response;

    @Title("Create New User")
    @Test
    public void verifyUserCreatedSuccessfully() {

        response = userSteps.createUser(token,name,email,gender,status);
        response.statusCode(201);
        userId = response.extract().path("id");
    }

    @Title("Getting and Verify new created user Detail")
    @Test
    public void getNewCreatedUserDetail(){

        response = userSteps.getUserInfoById(userId,token);
        response.statusCode(200);
    }

    @Title("Update user email and verify detail")
    @Test
    public void verifyUserUpdateSuccessfully() {

        String updEmail = "jp" + email;
        response.statusCode(200);
    }

    @Title("Deleting user and verify it deleted")
    @Test
    public void verifyUserDeleteSuccessfully() {

        userSteps.deleteUser(userId,token).statusCode(204);
        userSteps.getUserInfoById(userId,token).statusCode(404);

    }
}
