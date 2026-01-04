package mg.syga.infrastructure.randomuser;

import mg.syga.campaign.model.Account;
import mg.syga.campaign.model.Contact;
import mg.syga.campaign.model.Identity;
import mg.syga.campaign.model.People;

import java.util.List;
import java.util.UUID;

public class PeopleMapper {

    public static List<People> fromDTOs(List<RandomUserDTO> randomUserDTOS) {
        return randomUserDTOS.stream()
                .map(dto -> new People(
                        new Identity(UUID.fromString(dto.id()), dto.firstName(), dto.lastName(), dto.age(), dto.gender()),
                        new Contact(dto.email(), dto.phone()),
                        new Account(dto.username(), dto.avatar())
                ))
                .toList();
    }
}

