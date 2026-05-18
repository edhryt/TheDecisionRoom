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
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Builder.Default
    @OneToMany(mappedBy = "choiceOption", cascade = CascadeType.ALL)
    private List<OptionAdvantage> advantages = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "choiceOption", cascade = CascadeType.ALL)
    private List<OptionDisadvantage> disadvantages = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "issue_id")
    private Issue issue;
}
