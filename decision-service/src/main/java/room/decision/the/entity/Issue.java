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
    private Long id;

    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "discussion_id")
    private Long discussionId;

    @OneToOne
    private IssueContext issueContext;

    @OneToOne
    private MetDecision metDecision;

    @OneToMany
    private List<ChoiceOption> choiceOptions = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "issue_status_id")
    private IssueStatusEntity issueStatusEntity;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
