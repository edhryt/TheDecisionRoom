package room.decision.the.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import room.decision.the.dto.CreateUserRequest;
import room.decision.the.dto.UpdateUserRequest;
import room.decision.the.dto.UserResponse;
import room.decision.the.entity.User;
import room.decision.the.service.UserService;
import room.decision.the.usecase.DeleteUserUseCase;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final DeleteUserUseCase deleteUserUseCase;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {
        User createdUser = userService.createUser(createUserRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.from(createdUser));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("userId") Long userId) {
        User foundUser = userService.getUserById(userId);
        return ResponseEntity.ok(UserResponse.from(foundUser));
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable("userId") Long userId,
                                                   @RequestBody UpdateUserRequest updateUserRequest) {
        User updatedUser = userService.updateUser(userId, updateUserRequest);
        return ResponseEntity.ok(UserResponse.from(updatedUser));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable("userId") Long userId) {
        deleteUserUseCase.execute(userId);
        return ResponseEntity.ok().build();
    }
}
