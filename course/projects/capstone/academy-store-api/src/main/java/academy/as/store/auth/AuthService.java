package academy.as.store.auth;

import academy.as.store.user.AppUser;
import academy.as.store.user.AppUserRepository;
import academy.as.store.user.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** منطق ثبت‌نام؛ Controller نباید Business Rule را پیاده‌سازی کند. */
@Service
public class AuthService {
    private final AppUserRepository users;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AppUserRepository users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public AppUser register(String email, String rawPassword) {
        String normalizedEmail = email.trim().toLowerCase();
        if (users.existsByEmail(normalizedEmail)) {
            throw new IllegalArgumentException("Email is already registered");
        }
        return users.save(new AppUser(normalizedEmail, passwordEncoder.encode(rawPassword), Role.CUSTOMER));
    }
}
