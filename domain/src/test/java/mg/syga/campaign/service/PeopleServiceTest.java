package mg.syga.campaign.service;

import mg.syga.campaign.api.PeopleCriteria;
import mg.syga.campaign.model.Account;
import mg.syga.campaign.model.Contact;
import mg.syga.campaign.model.Identity;
import mg.syga.campaign.model.People;
import mg.syga.campaign.spi.PeopleInventory;
import mg.syga.campaign.spi.stub.PeopleInventoryStub;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class PeopleServiceTest {

    private final List<People> people = asList(
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

    private final PeopleInventory peopleInventory = new PeopleInventoryStub(people);
    private final PeopleCriteria service = new PeopleService(peopleInventory);


    @Test
    void should_throw_exception_when_minAge_is_negative() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> service.forAges(-1, 10));

        assertEquals("minAge must be >= 0", exception.getMessage());
    }

    @Test
    void should_throw_exception_when_maxAge_is_negative() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> service.forAges(10, -5));

        assertEquals("maxAge must be >= 0", exception.getMessage());
    }

    @Test
    void should_throw_exception_when_minAge_is_greater_than_maxAge() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> service.forAges(30, 20));

        assertEquals("minAge must be <= maxAge", exception.getMessage());
    }
}