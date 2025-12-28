package mg.syga.campaign.api;

import mg.syga.campaign.FilteredPeople;

public interface PeopleCriteria {
    FilteredPeople forAges(int minAge, int maxAge);
}
