package room.decision.the.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import room.decision.the.dto.CreateUserRequest;
import room.decision.the.dto.UpdateUserRequest;
import room.decision.the.entity.User;
import room.decision.the.exception.UserAlreadyExistsException;
import room.decision.the.exception.UserNotFoundException;
import room.decision.the.repository.UserRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User createUser(CreateUserRequest createUserRequest) {
        assertUsernameNotExists(createUserRequest.username());

        User user = User.builder()
                .name(createUserRequest.name())
                .username(createUserRequest.username())
                .createdAt(LocalDateTime.now())
                .build();

        return userRepository.saveAndFlush(user);
    }

    @Transactional(readOnly = true)
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Transactional
    public User updateUser(Long userId, UpdateUserRequest updateUserRequest) {
        User userToUpdate = getUserById(userId);

        if (updateUserRequest.name() != null && !updateUserRequest.name().trim().isBlank()) {
            userToUpdate.setName(updateUserRequest.name());
        }

        if (updateUserRequest.username() != null && !updateUserRequest.username().trim().isBlank()) {
            assertUsernameNotExists(updateUserRequest.username());
            userToUpdate.setUsername(updateUserRequest.username());
        }

        return userRepository.saveAndFlush(userToUpdate);
    }

    @Transactional
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    private void assertUsernameNotExists(String username) {
        if (userRepository.existsByUsername(username)) {
            throw new UserAlreadyExistsException("User already exists");
        }
    }
}
