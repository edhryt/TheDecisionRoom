package room.decision.the.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import room.decision.the.entity.User;

import java.time.LocalDateTime;

public record UserResponse(@JsonProperty("id") Long id,
                           @JsonProperty("name") String name,
                           @JsonProperty("username") String username,
                           @JsonProperty("created_at") LocalDateTime createdAt) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getCreatedAt()
        );
    }
}
