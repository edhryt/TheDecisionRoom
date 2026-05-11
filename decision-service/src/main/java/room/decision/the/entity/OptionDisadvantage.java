package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "option_disadvantage")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OptionDisadvantage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "disadvantage_title")
    private String disadvantageTitle;

    @ManyToOne
    @JoinColumn(name = "choice_option_id")
    private ChoiceOption choiceOption;
}
