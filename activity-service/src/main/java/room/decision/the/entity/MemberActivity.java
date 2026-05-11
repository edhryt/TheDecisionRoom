package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "member_activity")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "actor_id")
    private Long actorId;

    @Column(name = "target_id")
    private Long targetId;

    @Column(name = "activity_type")
    private String activityType;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;
}
