package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mistake")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mistake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", length = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name = "decision_analysis_id")
    private DecisionAnalysis decisionAnalysis;
}
