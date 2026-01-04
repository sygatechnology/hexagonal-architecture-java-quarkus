package mg.syga.infrastructure.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

@QuarkusTest
class CampaignControllerTest {


    @Test
    void testRandomUserStub() {
        given()
            .queryParam("count","5")
        .when()
            .get("/v2/randomuser")
        .then()
            .statusCode(200)
            .contentType("application/json")
            .body("people.size()", greaterThan(0))
            .body("people[0].identity.firstName", equalTo("Emily"))
            .body("people[1].identity.lastName", equalTo("Williams"));
    }


    @Test
    void test_start_campaign() {
        given()
        .when()
            .post("/campaign")
        .then()
            .statusCode(200)
            .body(is("Hello from Quarkus REST"));
    }

}