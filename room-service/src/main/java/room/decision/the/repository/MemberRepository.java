package room.decision.the.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import room.decision.the.entity.Member;
import room.decision.the.entity.MemberStatus;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    void deleteAllByRoom_Id(Long roomId);
    boolean existsByRoom_UsernameAndMemberId(String roomUsername, Long memberId);
    Optional<Member> findByRoom_UsernameAndMemberId(String roomUsername, Long memberId);

    @Query("SELECT m FROM Member m WHERE m.room.username = :roomUsername " +
            "AND m.memberStatusEntity.memberStatus = OWNER")
    Optional<Member> findRoomOwner(@Param("roomUsername") String roomUsername);
}
