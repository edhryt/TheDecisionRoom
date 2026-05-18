package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "choice_analysis")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DecisionAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "issue_id", nullable = false, updatable = false)
    private Long issueId;

    @Column(name = "creator_id", nullable = false, updatable = false)
    private Long creatorId;

    @Builder.Default
    @OneToMany(mappedBy = "decisionAnalysis", cascade = CascadeType.ALL)
    private List<Expectation> expectations = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "decisionAnalysis", cascade = CascadeType.ALL)
    private List<Consequence> consequences = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "decisionAnalysis", cascade = CascadeType.ALL)
    private List<Bias> biases = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "decisionAnalysis", cascade = CascadeType.ALL)
    private List<Mistake> mistakes = new ArrayList<>();

    @Column(name = "conclusion", nullable = false, length = 250)
    private String conclusion;

    @Column(name = "decision_quality", nullable = false)
    private Byte decisionQuality;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
