package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "discussion")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "roomId")
    private Long roomId;

    @Column(name = "issueId")
    private Long issueId;
}
