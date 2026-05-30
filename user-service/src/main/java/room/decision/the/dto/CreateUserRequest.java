package room.decision.the.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateUserRequest(@JsonProperty("name") String name,
                                @JsonProperty("username") String username) {
}
