package room.decision.the.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import room.decision.the.entity.Member;
import room.decision.the.entity.MemberStatus;
import room.decision.the.entity.MemberStatusEntity;
import room.decision.the.entity.Room;
import room.decision.the.exception.LeavingProhibitedException;
import room.decision.the.exception.MemberNotFoundException;
import room.decision.the.exception.MemberAlreadyExistsException;
import room.decision.the.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final RoomService roomService;
    private final MemberStatusEntityService memberStatusEntityService;
    private final MemberRepository memberRepository;

    @Transactional
    public Member addMemberToRoomIfNotExists(String roomUsername, Long memberId) {
        if (memberRepository.existsByRoom_UsernameAndMemberId(roomUsername, memberId)) {
            throw new MemberAlreadyExistsException("Room already has such member");
        }

        Room room = roomService.getByUsername(roomUsername);
        MemberStatusEntity memberStatusEntity = memberStatusEntityService.getOrCreateByMemberStatus(MemberStatus.MEMBER);
        Member member = Member.builder()
                .userId(memberId)
                .room(room)
                .memberStatusEntity(memberStatusEntity)
                .build();

        return memberRepository.saveAndFlush(member);
    }

    @Transactional(readOnly = true)
    public Member getByRoomUsernameAndMemberId(String roomUsername, Long memberId) {
        return memberRepository.findByRoom_UsernameAndMemberId(roomUsername, memberId)
                .orElseThrow(() -> new MemberNotFoundException("Member not found in this room"));
    }

    @Transactional(readOnly = true)
    public Member getRoomOwner(String roomUsername) {
        return memberRepository.findRoomOwner(roomUsername)
                .orElseThrow(() -> new MemberNotFoundException("Owner not found"));
    }

    @Transactional
    public void updateMember(Member member, MemberStatus memberStatus) {
        MemberStatusEntity memberStatusEntity = memberStatusEntityService.getOrCreateByMemberStatus(memberStatus);
        member.setMemberStatusEntity(memberStatusEntity);
        memberRepository.saveAndFlush(member);
    }

    @Transactional
    public void removeMemberFromRoom(String roomUsername, Long memberId) {
        Member member = getByRoomUsernameAndMemberId(roomUsername, memberId);

        if (MemberStatus.OWNER.equals(member.getMemberStatusEntity().getMemberStatus())) {
            throw new LeavingProhibitedException("You should promote another member to owner first or delete the room entirely");
        }

        member.setRoom(null);
        memberRepository.delete(member);
    }

    @Transactional
    public void removeAllMembersFromRoom(Long roomId) {
        memberRepository.deleteAllByRoom_Id(roomId);
    }
}
