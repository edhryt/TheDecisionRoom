package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "expectation")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Expectation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 30)
    private String title;

    @Column(name = "is_justified", nullable = false)
    private Boolean isJustified;

    @ManyToOne
    @JoinColumn(name = "decision_analysis_id")
    private DecisionAnalysis decisionAnalysis;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
