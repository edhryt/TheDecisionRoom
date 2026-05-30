package room.decision.the.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import room.decision.the.dto.CreateRoomRequest;
import room.decision.the.entity.Room;
import room.decision.the.dto.UpdateRoomRequest;
import room.decision.the.exception.RoomAlreadyExistsException;
import room.decision.the.exception.RoomNotFoundException;
import room.decision.the.repository.RoomRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    @Transactional
    public Room createRoomIfNotExists(CreateRoomRequest createRoomRequest) {
        if (roomRepository.existsByUsername(createRoomRequest.username())) {
            throw new RoomAlreadyExistsException("Room %s already exists".formatted(createRoomRequest.username()));
        }

        Room room = Room.builder()
                .name(createRoomRequest.name())
                .username(createRoomRequest.username())
                .createdAt(LocalDateTime.now())
                .build();

        return roomRepository.saveAndFlush(room);
    }

    @Transactional(readOnly = true)
    public Room getById(Long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException("Room not found"));
    }

    @Transactional(readOnly = true)
    public Room getByUsername(String username) {
        return roomRepository.findByUsername(username)
                .orElseThrow(() -> new RoomNotFoundException("Room not found"));
    }

    @Transactional
    public Room updateRoom(Long roomId, UpdateRoomRequest updateRoomRequest) {
        Room room = getById(roomId);

        if (updateRoomRequest.name() != null && !updateRoomRequest.name().trim().isBlank()) {
            room.setName(updateRoomRequest.name());
        }

        if (updateRoomRequest.username() != null && !updateRoomRequest.username().trim().isBlank()) {
            room.setUsername(updateRoomRequest.username());
        }

        return roomRepository.saveAndFlush(room);
    }

    @Transactional
    public void deleteById(Long roomId) {
        roomRepository.deleteById(roomId);
    }
}
