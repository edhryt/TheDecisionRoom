package room.decision.the.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import room.decision.the.entity.MemberStatus;
import room.decision.the.entity.MemberStatusEntity;

import java.util.Optional;

public interface MemberStatusEntityRepository extends JpaRepository<MemberStatusEntity, Long> {
    Optional<MemberStatusEntity> findByMemberStatus(MemberStatus memberStatus);
}
