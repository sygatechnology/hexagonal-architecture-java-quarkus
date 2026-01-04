package mg.syga.infrastructure.randomuser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RandomUserDTO(
        String id,
        String username,
        String email,
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        int age,
        String gender,
        String phone,
        String avatar
) {}

