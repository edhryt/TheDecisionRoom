package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "option_advantage")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OptionAdvantage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "choice_option_id")
    private ChoiceOption choiceOption;
}
