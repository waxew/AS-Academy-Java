package academy.as.store.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * تنظیمات پایه امنیت پروژه آموزشی.
 * در مرحله JWT، Basic Authentication با Token Filter جایگزین خواهد شد.
 */
@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // برای REST API آموزشی فعلاً CSRF غیرفعال است؛ در معماری Cookie باید دوباره بررسی شود.
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // مستندات API و Health برای مشاهده عمومی آزاد هستند.
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/actuator/health").permitAll()
                        // سایر endpointها نیازمند احراز هویت هستند.
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    /** Password خام نباید در دیتابیس ذخیره شود. */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
