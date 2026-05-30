package room.decision.the.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateRoomRequest(@JsonProperty("name") String name,
                                @JsonProperty("username") String username,
                                @JsonProperty("creator_id") Long creatorId) {
}
