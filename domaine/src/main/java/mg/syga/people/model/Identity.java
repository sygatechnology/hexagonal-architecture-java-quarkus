package mg.syga.people.model;

import java.util.UUID;

public record Identity(
        UUID uuid,
        String firstName,
        String lastName,
        int age,
        String gender
) {
    public Identity(String firstName, String lastName, int age, String gender) {
        this(UUID.randomUUID(), firstName, lastName, age, gender);
    }
}
