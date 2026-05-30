package room.decision.the.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import room.decision.the.dto.CreateRoomRequest;
import room.decision.the.dto.RoomResponse;
import room.decision.the.entity.Member;
import room.decision.the.entity.MemberStatus;
import room.decision.the.entity.Room;
import room.decision.the.service.MemberService;
import room.decision.the.service.RoomService;

@Component
@RequiredArgsConstructor
public class CreateRoomUseCase {
    private final RoomService roomService;
    private final MemberService memberService;

    public RoomResponse execute(CreateRoomRequest createRoomRequest) {
        Room createdRoom = roomService.createRoomIfNotExists(createRoomRequest);
        Member addedMember = memberService.addMemberToRoomIfNotExists(createRoomRequest.username(), createRoomRequest.creatorId());
        memberService.updateMember(addedMember, MemberStatus.OWNER);
        return RoomResponse.from(createdRoom);
    }
}
