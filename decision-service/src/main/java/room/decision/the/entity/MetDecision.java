package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "met_decision")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetDecision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "chosen_option_id")
    private ChoiceOption chosenOption;

    @Column(name = "explanation", nullable = false, length = 250)
    private String explanation;

    @Column(name = "made_at", nullable = false, updatable = false)
    private LocalDateTime madeAt;
}
