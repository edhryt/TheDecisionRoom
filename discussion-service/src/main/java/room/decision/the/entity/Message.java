package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "message")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "sender_id", nullable = false, updatable = false)
    private Long senderId;

    @Column(name = "content", nullable = false, length = 250)
    private String content;

    @ManyToOne
    @JoinColumn(name = "discussion_id")
    private Discussion discussion;

    @Column(name = "sent_at", nullable = false, updatable = false)
    private LocalDateTime sentAt;
}
