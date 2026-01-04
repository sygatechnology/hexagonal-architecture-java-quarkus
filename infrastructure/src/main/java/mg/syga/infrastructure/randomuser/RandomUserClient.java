package mg.syga.infrastructure.randomuser;

import io.quarkus.rest.client.reactive.ClientQueryParam;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;

import java.util.List;

@Path("/v2/randomuser")
@RegisterRestClient(configKey = "random-user-api")
@ClientQueryParam(name = "count", value = "${random-user-api-count}")
@ClientHeaderParam(name = "X-Api-Key", value = "${random-user-api-key}")
public interface RandomUserClient {

    @GET
    List<RandomUserDTO> getRandomUsers();
}
