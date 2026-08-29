package academy.as.store.common;

import java.time.Instant;
import java.util.Map;

/** قرارداد ثابت خطا برای Clientهای API. */
public record ApiError(
        Instant timestamp,
        int status,
        String code,
        String message,
        Map<String, String> fields) {
}
