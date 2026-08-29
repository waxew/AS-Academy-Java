package academy.as.store.security;

import static org.junit.jupiter.api.Assertions.assertEquals;

import academy.as.store.user.Role;
import org.junit.jupiter.api.Test;

/** Unit Test تولید و Parse توکن بدون اجرای Spring Context. */
class JwtServiceTest {
    @Test
    void createsReadableToken() {
        JwtService jwt = new JwtService("academy-test-secret-key-change-me-1234567890", 60_000);
        String token = jwt.createToken("student@example.com", Role.CUSTOMER);
        assertEquals("student@example.com", jwt.parse(token).getSubject());
        assertEquals("CUSTOMER", jwt.parse(token).get("role", String.class));
    }
}
