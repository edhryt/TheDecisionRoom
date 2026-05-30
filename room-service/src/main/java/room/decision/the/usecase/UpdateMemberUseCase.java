package room.decision.the.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import room.decision.the.dto.UpdateMemberRequest;
import room.decision.the.entity.Member;
import room.decision.the.entity.MemberStatus;
import room.decision.the.entity.MemberStatusEntity;
import room.decision.the.exception.AccessDeniedException;
import room.decision.the.service.MemberService;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UpdateMemberUseCase {
    private final MemberService memberService;

    public void execute(String roomUsername, Long memberId, UpdateMemberRequest updateMemberRequest) {
        Member owner = memberService.getRoomOwner(roomUsername);

        if (!Objects.equals(owner.getId(), updateMemberRequest.initiatorId())) {
            throw new AccessDeniedException("Only owner may update member status");
        }

        if (MemberStatus.OWNER.equals(updateMemberRequest.memberStatus())) {
            memberService.updateMember(owner, MemberStatus.MEMBER);
        }

        Member member = memberService.getByRoomUsernameAndMemberId(roomUsername, memberId);
        memberService.updateMember(member, updateMemberRequest.memberStatus());
    }
}
