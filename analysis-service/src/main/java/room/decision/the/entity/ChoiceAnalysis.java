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
public class ChoiceAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "choice_option_id")
    private Long choiceOptionId;

    @Column(name = "creator_id")
    private Long creatorId;

    @OneToMany
    private List<Expectation> expectations = new ArrayList<>();

    @OneToMany
    private List<Consequence> consequences = new ArrayList<>();

    @OneToMany
    private List<Bias> biases = new ArrayList<>();

    @Column(name = "conclusion")
    private String conclusion;

    @Column(name = "decision_quality")
    private Byte decisionQuality;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
