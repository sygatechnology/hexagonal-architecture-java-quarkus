package mg.syga.campaign;

import mg.syga.campaign.api.PeopleCriteria;
import mg.syga.campaign.model.People;
import mg.syga.campaign.spi.PeopleInventory;

import java.util.List;

public class PeopleService implements PeopleCriteria {

    private final PeopleInventory peopleInventory;

    public PeopleService(PeopleInventory peopleInventory) {
        this.peopleInventory = peopleInventory;
    }

    @Override
    public FilteredPeople forAges(int minAge, int maxAge) {
        List<People> people = peopleInventory.getAllPeople();
        return new FilteredPeople(filterByAgeRange(people, minAge, maxAge));
    }

    private List<People> filterByAgeRange(List<People> people, int minAge, int maxAge) {
        return people.stream()
                .filter(person -> person.identity().age() >= minAge && person.identity().age() <= maxAge)
                .toList();
    }

}
