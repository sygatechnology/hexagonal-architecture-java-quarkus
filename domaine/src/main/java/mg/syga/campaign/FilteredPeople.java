package mg.syga.campaign;

import mg.syga.campaign.model.People;

import java.util.List;
import java.util.UUID;

public record FilteredPeople(UUID id, List<People> people) {
    public FilteredPeople(List<People> people) {
        this(UUID.randomUUID(), people);
    }
}
