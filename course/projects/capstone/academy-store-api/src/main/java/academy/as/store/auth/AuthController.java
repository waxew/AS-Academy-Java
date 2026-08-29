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

/** Endpoint عمومی ثبت‌نام. Login/JWT در گام امنیتی بعدی روی همین ماژول قرار می‌گیرد. */
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

    public record RegisterRequest(
            @NotBlank @Email String email,
            @NotBlank @Size(min = 8, max = 72) String password) { }

    /** پاسخ عمداً Password Hash را برنمی‌گرداند. */
    public record UserResponse(Long id, String email, String role) { }
}
