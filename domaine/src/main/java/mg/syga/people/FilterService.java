package mg.syga.people;

import mg.syga.people.api.FilterCriteria;
import mg.syga.people.model.People;
import mg.syga.people.spi.PeopleInventory;

import java.util.List;

public class FilterService implements FilterCriteria {

    private final PeopleInventory peopleInventory;

    public FilterService(PeopleInventory peopleInventory) {
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
