package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "username", nullable = false, unique = true, length = 20)
    private String username;

    @OneToOne
    @JoinColumn(name = "rating_id")
    private Rating rating;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
