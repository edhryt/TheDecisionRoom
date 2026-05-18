package room.decision.the.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import room.decision.the.entity.MemberActivity;

public interface MemberActivityRepository extends JpaRepository<MemberActivity, Long> {
}
