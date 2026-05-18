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
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "issueId", nullable = false, updatable = false)
    private Long issueId;

    @Builder.Default
    @OneToMany(mappedBy = "discussion", cascade = CascadeType.ALL)
    private List<Message> messages = new ArrayList<>();
}
