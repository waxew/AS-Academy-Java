package academy.as.store.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/** Repository دسترسی به کاربران. */
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
    boolean existsByEmail(String email);
}
