package mg.syga.infrastructure.controller;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mg.syga.infrastructure.request.CampaignRequest;
import mg.syga.infrastructure.response.CampaignResult;
import mg.syga.infrastructure.service.CampaignService;

@Path("/campaign")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response startCampaign(CampaignRequest request) {
        int result = campaignService.startCampaign(request.minAge(), request.maxAge());
        return Response
                .ok(new CampaignResult(result))
                .build();
    }
}
