package room.decision.the.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Builder.Default
    @OneToMany(mappedBy = "room")
    private List<MemberRoomDetails> memberRoomDetails = new ArrayList<>();

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
