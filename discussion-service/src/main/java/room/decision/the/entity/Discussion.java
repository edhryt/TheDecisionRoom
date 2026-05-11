package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @Builder.Default
    @OneToMany(mappedBy = "discussion")
    private List<Message> messages = new ArrayList<>();
}
