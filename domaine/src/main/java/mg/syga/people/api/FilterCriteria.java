package mg.syga.people.api;

import mg.syga.people.FilteredPeople;

public interface FilterCriteria {
    FilteredPeople forAges(int minAge, int maxAge);
}
