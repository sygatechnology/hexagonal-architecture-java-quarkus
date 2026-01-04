package mg.syga.infrastructure.randomuser;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mg.syga.campaign.model.People;
import mg.syga.campaign.spi.PeopleInventory;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class RandomUser implements PeopleInventory {

    private final RandomUserClient client;

    @Inject
    public RandomUser(@RestClient RandomUserClient client) {
        this.client = client;
    }

    @Override
    public List<People> getAllPeople() {
        List<RandomUserDTO> randomUserDTOS = client.getRandomUsers();
        return PeopleMapper.fromDTOs(randomUserDTOS);
    }
}
