package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "issue_status")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private IssueStatus status;
}
