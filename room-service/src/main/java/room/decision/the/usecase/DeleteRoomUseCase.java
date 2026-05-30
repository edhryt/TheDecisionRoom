package room.decision.the.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import room.decision.the.service.MemberService;
import room.decision.the.service.RoomService;

@Component
@RequiredArgsConstructor
public class DeleteRoomUseCase {
    private final RoomService roomService;
    private final MemberService memberService;

    public void execute(Long roomId) {
        //TODO: call other services to remove their rows mapped to room
        memberService.removeAllMembersFromRoom(roomId);
        roomService.deleteById(roomId);
    }
}
