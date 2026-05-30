package room.decision.the.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateUserRequest(@JsonProperty("name") String name,
                                @JsonProperty("username") String username) {
}
