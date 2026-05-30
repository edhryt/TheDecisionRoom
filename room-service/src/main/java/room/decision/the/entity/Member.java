package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "user_id", nullable = false, updatable = false, unique = true)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "member_status_id")
    private MemberStatusEntity memberStatusEntity;
}
