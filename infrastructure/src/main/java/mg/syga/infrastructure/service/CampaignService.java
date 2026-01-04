package mg.syga.infrastructure.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mg.syga.campaign.api.PeopleCriteria;
import mg.syga.campaign.entity.FilteredPeople;
import mg.syga.campaign.service.PeopleService;
import mg.syga.campaign.spi.Notification;
import mg.syga.campaign.spi.PeopleInventory;

@ApplicationScoped
public class CampaignService {

    private final PeopleInventory peopleInventory;
    private final Notification notification;

    @Inject
    public CampaignService(PeopleInventory peopleInventory, Notification notification) {
        this.peopleInventory = peopleInventory;
        this.notification = notification;
    }

    public int startCampaign(int minAge, int maxAge) {
        PeopleCriteria peopleCriteria = new PeopleService(peopleInventory);
        FilteredPeople filteredPeople = peopleCriteria.forAges(minAge, maxAge);
        notifyExternalSystems(filteredPeople);
        return computeSomeValue(filteredPeople);
    }

    private void notifyExternalSystems(FilteredPeople filteredPeople) {
        filteredPeople.people()
                .forEach(person -> {
                    notification.sendSMS(person.contact().phone(), "Campaign started!");
                    notification.sendEmail(person.contact().email()," Campaign Notification","The campaign has started.");
                });
    }

    private int computeSomeValue(FilteredPeople filteredPeople) {
        return Math.toIntExact(filteredPeople.people().size());
    }

}
