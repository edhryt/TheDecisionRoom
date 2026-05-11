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
    private Long id;

    @Column(name = "senderId")
    private Long senderId;

    @Column(name = "discussionId")
    private Long discussionId;

    @Column(name = "content")
    private String content;

    @Column(name = "sentAt")
    private LocalDateTime sentAt;
}
