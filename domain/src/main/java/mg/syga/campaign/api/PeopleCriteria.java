package mg.syga.campaign.api;

import mg.syga.campaign.entity.FilteredPeople;

public interface PeopleCriteria {
    FilteredPeople forAges(int minAge, int maxAge);
}
