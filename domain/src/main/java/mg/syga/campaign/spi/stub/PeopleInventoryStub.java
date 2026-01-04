package mg.syga.campaign.spi.stub;

import mg.syga.campaign.model.Account;
import mg.syga.campaign.model.Contact;
import mg.syga.campaign.model.Identity;
import mg.syga.campaign.model.People;
import mg.syga.campaign.spi.PeopleInventory;

import java.util.List;

import static java.util.Arrays.asList;

public class PeopleInventoryStub implements PeopleInventory {

    private static final List<People> DEFAULT_PEOPLE = asList(
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
                    new Identity("Emma","Miller", 11, "female"),
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
                    new Identity("Isabella","Anderson",63,"female"),
                    new Contact("isabella.anderson@x.dummyjson.com","+49 770-658-4885"),
                    new Account("isabellad","https://dummyjson.com/icon/isabellad/128")
            )
    );

    private final List<People> people;

    public PeopleInventoryStub() {
        people = DEFAULT_PEOPLE;
    }

    public PeopleInventoryStub(List<People> people) {
        this.people = people;
    }

    @Override
    public List<People> getAllPeople() {
        return DEFAULT_PEOPLE;
    }
}
