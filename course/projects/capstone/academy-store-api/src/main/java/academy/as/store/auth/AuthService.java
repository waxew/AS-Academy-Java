package academy.as.store.auth;

import academy.as.store.security.JwtService;
import academy.as.store.user.AppUser;
import academy.as.store.user.AppUserRepository;
import academy.as.store.user.Role;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** منطق ثبت‌نام و ورود؛ Controller فقط قرارداد HTTP را مدیریت می‌کند. */
@Service
public class AuthService {
    private final AppUserRepository users;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(AppUserRepository users, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Transactional
    public AppUser register(String email, String rawPassword) {
        String normalizedEmail = normalize(email);
        if (users.existsByEmail(normalizedEmail)) {
            throw new IllegalArgumentException("Email is already registered");
        }
        return users.save(new AppUser(normalizedEmail, passwordEncoder.encode(rawPassword), Role.CUSTOMER));
    }

    @Transactional(readOnly = true)
    public String login(String email, String rawPassword) {
        AppUser user = users.findByEmail(normalize(email))
                .orElseThrow(() -> new BadCredentialsException("Invalid credentials"));
        if (!passwordEncoder.matches(rawPassword, user.getPasswordHash())) {
            throw new BadCredentialsException("Invalid credentials");
        }
        return jwtService.createToken(user);
    }

    private String normalize(String email) {
        return email.trim().toLowerCase();
    }
}
