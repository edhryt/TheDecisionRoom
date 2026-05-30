package room.decision.the.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import room.decision.the.entity.MemberStatus;
import room.decision.the.entity.MemberStatusEntity;
import room.decision.the.repository.MemberStatusEntityRepository;

@Service
@RequiredArgsConstructor
public class MemberStatusEntityService {
    private final MemberStatusEntityRepository memberStatusEntityRepository;

    @Transactional
    public MemberStatusEntity getOrCreateByMemberStatus(MemberStatus memberStatus) {
        return memberStatusEntityRepository.findByMemberStatus(memberStatus)
                .orElseGet(() -> create(memberStatus));
    }

    private MemberStatusEntity create(MemberStatus memberStatus) {
        MemberStatusEntity memberStatusEntity = MemberStatusEntity.builder()
                .memberStatus(memberStatus)
                .build();
        return memberStatusEntityRepository.saveAndFlush(memberStatusEntity);
    }
}
