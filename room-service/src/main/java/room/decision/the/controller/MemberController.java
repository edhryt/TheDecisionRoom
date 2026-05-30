package room.decision.the.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import room.decision.the.dto.UpdateMemberRequest;
import room.decision.the.service.MemberService;
import room.decision.the.usecase.UpdateMemberUseCase;

@RestController
@RequestMapping("/api/v1/rooms/{roomUsername}/members/{memberId}")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final UpdateMemberUseCase updateMemberUseCase;

    @PostMapping
    public ResponseEntity<Void> joinRoom(@PathVariable("roomUsername") String roomUsername,
                                         @PathVariable("memberId") Long memberId) {
        memberService.addMemberToRoomIfNotExists(roomUsername, memberId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<Void> updateMember(@PathVariable("roomUsername") String roomUsername,
                                             @PathVariable("memberId") Long memberId,
                                             @RequestBody UpdateMemberRequest updateMemberRequest) {
        updateMemberUseCase.execute(roomUsername, memberId, updateMemberRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> leaveRoom(@PathVariable("roomUsername") String roomUsername,
                                          @PathVariable("memberId") Long memberId) {
        memberService.removeMemberFromRoom(roomUsername, memberId);
        return ResponseEntity.ok().build();
    }
}
