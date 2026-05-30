package room.decision.the.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import room.decision.the.service.UserService;

@Component
@RequiredArgsConstructor
public class DeleteUserUseCase {
    private final UserService userService;

    public void execute(Long userId) {

        userService.deleteById(userId);
    }
}
