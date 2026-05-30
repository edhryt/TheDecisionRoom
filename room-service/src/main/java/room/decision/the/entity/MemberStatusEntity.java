package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member_status")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_status", nullable = false, unique = true, updatable = false)
    private MemberStatus memberStatus;
}
