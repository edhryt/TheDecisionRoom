package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "expectation")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Expectation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "is_justified")
    private Boolean isJustified;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "choice_analysis_id")
    private ChoiceAnalysis choiceAnalysis;
}
