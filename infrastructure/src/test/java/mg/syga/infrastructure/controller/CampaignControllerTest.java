package mg.syga.infrastructure.controller;

import com.github.tomakehurst.wiremock.client.WireMock;
import io.quarkiverse.wiremock.devservice.ConnectWireMock;
import io.quarkiverse.wiremock.devservice.WireMockConfigKey;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import mg.syga.campaign.model.People;
import mg.syga.infrastructure.randomuser.PeopleMapper;
import mg.syga.infrastructure.randomuser.RandomUserDTO;
import mg.syga.infrastructure.request.CampaignRequest;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@ConnectWireMock
class CampaignControllerTest {

    WireMock wiremock;
    @ConfigProperty(name = WireMockConfigKey.PORT)
    Integer wiremockPort;

    @ConfigProperty(name = "quarkus.http.port")
    Integer testPort;

    @BeforeEach
    void setup() {
        wiremock.register(get(urlEqualTo("/v2/randomuser"))
                .willReturn(aResponse()
                        .withHeader("Content-Type","application/json")
                        .withBodyFile("payloads/randomuser.json")
                        .withStatus(200)
                )
        );
    }

    @Test
    void test_random_user_stub() {
        baseURI = "http://localhost";
        port = wiremockPort;
        List<RandomUserDTO> dtos =given()
            .contentType("application/json")
        .when()
            .get("/v2/randomuser")
        .then()
            .statusCode(200)
            .contentType("application/json")
            .extract()
            .body()
            .as(new TypeRef<>() {
            });
        List<People> people = PeopleMapper.fromDTOs(dtos);
        assertThat(people.size()).isGreaterThan(0);
        assertThat(people.getFirst().identity().firstName()).isEqualTo("Toni");
    }


    @Test
    void test_start_campaign() {
        baseURI = "http://localhost";
        port = testPort;
        given()
            .contentType("application/json")
            .body(new CampaignRequest(18, 45))
        .when()
            .post("/campaign")
        .then()
            .statusCode(200)
            .body(is("Hello from Quarkus REST"));
    }

}