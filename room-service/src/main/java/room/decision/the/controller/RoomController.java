package room.decision.the.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import room.decision.the.entity.Room;
import room.decision.the.dto.CreateRoomRequest;
import room.decision.the.dto.RoomResponse;
import room.decision.the.dto.UpdateRoomRequest;
import room.decision.the.service.RoomService;
import room.decision.the.usecase.CreateRoomUseCase;
import room.decision.the.usecase.DeleteRoomUseCase;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;
    private final CreateRoomUseCase createRoomUseCase;
    private final DeleteRoomUseCase deleteRoomUseCase;

    @PostMapping
    public ResponseEntity<RoomResponse> createRoom(@RequestBody CreateRoomRequest createRoomRequest) {
        RoomResponse roomResponse = createRoomUseCase.execute(createRoomRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(roomResponse);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomResponse> getRoomById(@PathVariable("roomId") Long roomId) {
        Room room = roomService.getById(roomId);
        return ResponseEntity.ok(RoomResponse.from(room));
    }

    @PatchMapping("/{roomId}")
    public ResponseEntity<RoomResponse> updateRoomById(@PathVariable("roomId") Long roomId,
                                                       @RequestBody UpdateRoomRequest updateRoomRequest) {
        Room room = roomService.updateRoom(roomId, updateRoomRequest);
        return ResponseEntity.ok(RoomResponse.from(room));
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteRoomById(@PathVariable("roomId") Long roomId) {
        deleteRoomUseCase.execute(roomId);
        return ResponseEntity.ok().build();
    }
}
