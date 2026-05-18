package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member_viewpoint")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberViewpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "chosen_option_id")
    private ChoiceOption chosenOption;

    @Column(name = "member_id", nullable = false, updatable = false)
    private Long memberId;

    @Column(name = "reasoning", nullable = false, length = 250)
    private String reasoning;
}
