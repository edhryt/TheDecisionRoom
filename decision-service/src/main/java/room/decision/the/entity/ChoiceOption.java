package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "choice_option")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChoiceOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Builder.Default
    @OneToMany(mappedBy = "choiceOption")
    private List<OptionAdvantage> advantages = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "choiceOption")
    private List<OptionDisadvantage> disadvantages = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "issue_id")
    private Issue issue;
}
