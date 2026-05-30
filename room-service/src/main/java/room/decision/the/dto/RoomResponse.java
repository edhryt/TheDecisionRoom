package room.decision.the.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import room.decision.the.entity.Room;

import java.time.LocalDateTime;

public record RoomResponse(@JsonProperty("name") String name,
                           @JsonProperty("username") String username,
                           @JsonProperty("created_at") LocalDateTime createdAt) {
    public static RoomResponse from(Room room) {
        return new RoomResponse(
                room.getName(),
                room.getUsername(),
                room.getCreatedAt()
        );
    }
}
