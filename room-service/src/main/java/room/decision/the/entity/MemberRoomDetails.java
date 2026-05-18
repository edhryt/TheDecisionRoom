package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member_room_details")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberRoomDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "member_id", nullable = false, updatable = false, unique = true)
    private Long memberId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "member_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;
}
