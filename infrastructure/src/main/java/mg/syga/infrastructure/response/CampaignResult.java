package mg.syga.infrastructure.response;

import java.util.Date;

public record CampaignResult(Date date, int total) {
    public CampaignResult(int total) {
        this(new Date(), total);
    }
}
