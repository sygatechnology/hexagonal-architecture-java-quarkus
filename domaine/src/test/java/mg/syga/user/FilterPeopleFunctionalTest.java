package mg.syga.user;

import mg.syga.people.FilterService;
import mg.syga.people.FilteredPeople;
import mg.syga.people.api.FilterCriteria;
import mg.syga.people.model.Account;
import mg.syga.people.model.Contact;
import mg.syga.people.model.Identity;
import mg.syga.people.model.People;
import mg.syga.people.spi.PeopleInventory;
import mg.syga.people.spi.stubs.PeopleInventoryStub;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class FilterPeopleFunctionalTest {

    @Test
    void search_only_for_people_whose_age_is_between_18_and_45() {
        // Given
        var people = asList(
                new People(
                        new Identity("Emily","Johnson",29,"female"),
                        new Contact("emily.johnson@x.dummyjson.com","+81 965-431-3024"),
                        new Account("emilys","https://dummyjson.com/icon/emilys/128")
                ),
                new People(
                        new Identity("Michael", "Williams",36,"male"),
                        new Contact("michael.williams@x.dummyjson.com", "+49 258-627-6644"),
                        new Account("michaelw", "https://dummyjson.com/icon/michaelw/128")
                ),
                new People(
                        new Identity("Sophia", "Brown",43,"female"),
                        new Contact("sophia.brown@x.dummyjson.com","+81 210-652-2785"),
                        new Account("sophiab", "https://dummyjson.com/icon/sophiab/128")
                ),
                new People(
                        new Identity("James","Davis",46,"male"),
                        new Contact("james.davis@x.dummyjson.com","+49 614-958-9364"),
                        new Account("jamesd","https://dummyjson.com/icon/jamesd/128")
                ),
                new People(
                        new Identity("Emma","Miller", 31, "female"),
                        new Contact("emma.miller@x.dummyjson.com","+91 759-776-1614"),
                        new Account("emmaj","https://dummyjson.com/icon/emmaj/128")
                ),
                new People(
                        new Identity("Olivia","Wilson", 23, "female"),
                        new Contact("olivia.wilson@x.dummyjson.com","+91 607-295-6448"),
                        new Account("oliviaw","https://dummyjson.com/icon/oliviaw/128")
                ),
                new People(
                        new Identity("Alexander","Jones",39,"male"),
                        new Contact("alexander.jones@x.dummyjson.com","+61 260-824-4986"),
                        new Account("alexanderj","https://dummyjson.com/icon/alexanderj/128")
                ),
                new People(
                        new Identity("Ava","Taylor",28,"female"),
                        new Contact("ava.taylor@x.dummyjson.com","+1 458-853-7877"),
                        new Account("avat","https://dummyjson.com/icon/avat/128")
                ),
                new People(
                        new Identity("Ethan","Martinez",34,"male"),
                        new Contact("ethan.martinez@x.dummyjson.com","+92 933-608-5081"),
                        new Account("ethanm","https://dummyjson.com/icon/ethanm/128")
                ),
                new People(
                        new Identity("Isabella","Anderson",32,"female"),
                        new Contact("isabella.anderson@x.dummyjson.com","+49 770-658-4885"),
                        new Account("isabellad","https://dummyjson.com/icon/isabellad/128")
                )
        );

        var minAge = 18;
        var maxAge = 45;

        PeopleInventory peopleInventory = new PeopleInventoryStub(people);
        FilterCriteria filterCriteria = new FilterService(peopleInventory);

        // When
        FilteredPeople filteredPeople = filterCriteria.forAges(minAge, maxAge);

        // Then
        System.out.println(filteredPeople);

        Condition<People> ageBetween18And45 = new Condition<>(
                user -> user.identity().age() >= minAge && user.identity().age() <= maxAge,
                "age between 18 and 45");

        assertThat(filteredPeople.people()).are(ageBetween18And45);

    }

}