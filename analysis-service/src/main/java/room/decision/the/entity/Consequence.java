package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "consequence")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consequence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ConsequenceType type;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
