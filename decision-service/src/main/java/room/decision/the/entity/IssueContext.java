package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "issue_context")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueContext {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "aim")
    private String aim;

    @Column(name = "constraints")
    private String constraints;

    @Column(name = "given_knowledge")
    private String givenKnowledge;

    @Column(name = "deadline")
    private LocalDateTime deadline;

    @Column(name = "budget")
    private Double budget;

    @Column(name = "requirements")
    private String requirements;
}
