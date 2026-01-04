package mg.syga.infrastructure.randomuser;

import jakarta.enterprise.context.ApplicationScoped;
import mg.syga.campaign.model.People;
import mg.syga.campaign.spi.PeopleInventory;

import java.util.List;

@ApplicationScoped
public class RandomUser implements PeopleInventory {
    @Override
    public List<People> getAllPeople() {
        return List.of();
    }
}
