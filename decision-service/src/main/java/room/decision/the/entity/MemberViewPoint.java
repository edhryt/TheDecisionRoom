package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "choice_option_voters")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberViewPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "chosen_option_id")
    private ChoiceOption chosenOption;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "reasoning")
    private String reasoning;
}
