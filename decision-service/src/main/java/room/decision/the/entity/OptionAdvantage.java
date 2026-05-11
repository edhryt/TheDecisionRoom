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
    private Long id;

    @Column(name = "advantage_title")
    private String advantageTitle;

    @ManyToOne
    @JoinColumn(name = "choice_option_id")
    private ChoiceOption choiceOption;
}
