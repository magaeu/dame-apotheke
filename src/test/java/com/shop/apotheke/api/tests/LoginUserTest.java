package com.shop.apotheke.api.tests;

import com.shop.apotheke.api.dto.ErrorResponseDTO;
import com.shop.apotheke.api.dto.LoginDTO;
import com.shop.apotheke.api.dto.LoginResponseDTO;
import com.shop.apotheke.api.setup.BaseTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.shop.apotheke.api.contants.Checks.*;
import static com.shop.apotheke.api.contants.Credentials.DEFAULT_CUSTOMER_NUMBER;
import static com.shop.apotheke.api.contants.Credentials.DEFAULT_CUSTOMER_PASSWORD;
import static com.shop.apotheke.api.contants.Endpoints.LOGIN_ENDPOINT;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginUserTest extends BaseTest {
    private LoginDTO credentials;
    private LoginResponseDTO loginResponse;
    private ErrorResponseDTO errorResponse;

    @Test
    @DisplayName("01.1 - Login user with valid credentials")
    public void loginUserWithValidCredentials() {
        credentials = createCredentials(DEFAULT_CUSTOMER_NUMBER, DEFAULT_CUSTOMER_PASSWORD);
        loginResponse = given()
                .spec(getReq())
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .and()
                .body(credentials)
                .when()
                .post(LOGIN_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(LoginResponseDTO.class);

        assertThat(loginResponse.getToken()).as(CHECK_TOKEN).isNot(null);
        assertThat(loginResponse.getTokenType()).as(CHECK_TOKEN_TYPE).isEqualTo("bearer");
    }

    private LoginDTO createCredentials(String customerNumber, String password) {
        return new LoginDTO()
                .setCustomerNumber(customerNumber)
                .setPassword(password);
    }

    @Test
    @DisplayName("01.2 - Login user with invalid credentials")
    public void loginUserWitInvalidCredentials() {
        credentials = createCredentials(DEFAULT_CUSTOMER_NUMBER, "asjlasdlksdfkdf");
        errorResponse = given()
                .spec(getReq())
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .and()
                .body(credentials)
                .when()
                .post(LOGIN_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract().as(ErrorResponseDTO.class);

        assertThat(errorResponse.getStatusCode()).as(CHECK_STATUS_CODE).isEqualTo(HttpStatus.SC_BAD_REQUEST);
        assertThat(errorResponse.getError()).as(CHECK_ERROR).isEqualTo("Bad Request");
        assertThat(errorResponse.getMessage()).as(CHECK_MESSAGE)
                .isEqualTo("customer-authentication.error.customer.not-found");
    }
}
