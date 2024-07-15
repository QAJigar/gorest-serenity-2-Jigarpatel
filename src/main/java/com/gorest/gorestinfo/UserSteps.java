package com.gorest.gorestinfo;

import com.gorest.constants.EndPoints;
import com.gorest.model.UserPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class UserSteps {

    @Step("Creating User with name: {1}, email:{2},gender{3},status:{4}")
    public ValidatableResponse createUser(String token, String name,String email, String gender,String status) {

        UserPojo userPojo = UserPojo.getUserPojo(name, email, gender, status);

        return SerenityRest.given()
                .header("Content-type","application/json")
                .header("Authorization" , "Bearer " + token)
                .when()
                .body(userPojo)
                .post(EndPoints.GET_ALL_USER)
                .then();
    }

    @Step("Geting user detail by userId: {0}")
    public ValidatableResponse getUserInfoById(int userId, String token){
        return SerenityRest.given()
                .pathParam("userID", userId)
                .header("Authorization" , "Bearer " + token)
                .when()
                .get(EndPoints.GET_SINGLE_USER_BY_ID)
                .then();
    }

    @Step("Updating user with userId: {0}, name: {1}, email: {2}, gender: {3}, status: {4}")
    public ValidatableResponse updateUserById(int userId,String token, String name, String email, String gender,String status){
        UserPojo userPojo = UserPojo.getUserPojo(name,email,gender,status);
        return SerenityRest.given()
                .pathParam("userID", userId)
                .header("Content-type","application/json")
                .header("Authorization" , "Bearer " + token)
                .when()
                .body(userPojo)
                .patch(EndPoints.UPDATE_SINGLE_USER_BY_ID)
                .then();
    }

    @Step("Deleting user by userID: {0}")
    public ValidatableResponse deleteUser(int userId,String token){
        return SerenityRest.given()
                .pathParam("userID", userId)
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(EndPoints.DELETE_SINGLE_USER_BY_ID)
                .then();
    }













}
