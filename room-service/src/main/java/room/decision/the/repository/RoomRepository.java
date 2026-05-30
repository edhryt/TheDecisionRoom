package room.decision.the.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import room.decision.the.entity.Room;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    boolean existsByUsername(String username);
    Optional<Room> findByUsername(String username);
}
