package academy.as.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * نقطه شروع پروژه نهایی Academy Store API.
 */
@SpringBootApplication
public class AcademyStoreApplication {

    public static void main(String[] args) {
        // Spring Context و Web Server را راه‌اندازی می‌کند.
        SpringApplication.run(AcademyStoreApplication.class, args);
    }
}
