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
    private Long id;

    @OneToOne
    private ChoiceOption chosenOption;

    @Column(name = "explanation")
    private String explanation;

    @Column(name = "made_at")
    private LocalDateTime madeAt;
}
