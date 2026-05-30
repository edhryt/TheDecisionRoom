package room.decision.the.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import room.decision.the.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
}
