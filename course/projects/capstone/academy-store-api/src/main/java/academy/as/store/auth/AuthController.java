package academy.as.store.auth;

import academy.as.store.user.AppUser;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/** API عمومی Authentication شامل Register و Login. */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse register(@Valid @RequestBody RegisterRequest request) {
        AppUser user = authService.register(request.email(), request.password());
        return new UserResponse(user.getId(), user.getEmail(), user.getRole().name());
    }

    @PostMapping("/login")
    public TokenResponse login(@Valid @RequestBody LoginRequest request) {
        return new TokenResponse(authService.login(request.email(), request.password()), "Bearer");
    }

    public record RegisterRequest(@NotBlank @Email String email, @NotBlank @Size(min = 8, max = 72) String password) { }
    public record LoginRequest(@NotBlank @Email String email, @NotBlank String password) { }
    public record UserResponse(Long id, String email, String role) { }
    public record TokenResponse(String accessToken, String tokenType) { }
}
