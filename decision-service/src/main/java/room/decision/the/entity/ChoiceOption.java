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

    @OneToMany
    private List<OptionAdvantage> advantages = new ArrayList<>();

    @OneToMany
    private List<OptionDisadvantage> disadvantages = new ArrayList<>();
}
