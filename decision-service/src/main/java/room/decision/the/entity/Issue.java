package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "issue")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "room_id", nullable = false, updatable = false)
    private Long roomId;

    @Column(name = "discussion_id")
    private Long discussionId;

    @Column(name = "creator_id", nullable = false, updatable = false)
    private Long creatorId;

    @ManyToOne
    @JoinColumn(name = "issue_status_id")
    private IssueStatusEntity issueStatusEntity;

    @OneToOne
    @JoinColumn(name = "issue_context_id")
    private IssueContext issueContext;

    @OneToOne
    @JoinColumn(name = "met_decision_id")
    private MetDecision metDecision;

    @Builder.Default
    @OneToMany(mappedBy = "issue")
    private List<ChoiceOption> choiceOptions = new ArrayList<>();

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
