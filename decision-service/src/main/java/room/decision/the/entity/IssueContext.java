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
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "aim", nullable = false, length = 50)
    private String aim;

    @Column(name = "constraints", nullable = false, length = 250)
    private String constraints;

    @Column(name = "given_knowledge", nullable = false, length = 250)
    private String givenKnowledge;

    @Column(name = "budget")
    private Double budget;

    @Column(name = "requirements", nullable = false, length = 250)
    private String requirements;

    @Column(name = "deadline", nullable = false, updatable = false)
    private LocalDateTime deadline;
}
