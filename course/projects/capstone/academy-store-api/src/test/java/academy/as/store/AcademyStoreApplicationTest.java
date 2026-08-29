package academy.as.store;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/** Smoke Test: کل Spring Context باید با دیتابیس تست بالا بیاید. */
@SpringBootTest
class AcademyStoreApplicationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void applicationContextLoads() {
        assertNotNull(context);
    }
}
