package mg.syga.infrastructure.controller;

import io.quarkiverse.wiremock.devservice.ConnectWireMock;
import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.junit.jupiter.api.BeforeEach;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import com.github.tomakehurst.wiremock.matching.EqualToPattern;

@QuarkusIntegrationTest
@ConnectWireMock
class CampaignControllerIT extends CampaignControllerTest {

    @BeforeEach
    void setup() {
        stubFor(get(urlPathMatching("/v2/randomuser"))
                .withQueryParam("count", new EqualToPattern("5"))
                .willReturn(aResponse()
                        .withHeader("Content-Type","application/json")
                        .withBodyFile("payloads/randomuser.json")
                        .withStatus(200)
                )
        );
    }




}
