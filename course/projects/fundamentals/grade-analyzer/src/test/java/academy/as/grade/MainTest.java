package academy.as.grade;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** تست‌های مرجع پروژه Grade Analyzer. */
class MainTest {
    private final int[] scores = {18, 14, 20, 11, 17};

    @Test
    void calculatesMinimum() {
        assertEquals(11, Main.min(scores));
    }

    @Test
    void calculatesMaximum() {
        assertEquals(20, Main.max(scores));
    }

    @Test
    void calculatesAverage() {
        assertEquals(16.0, Main.average(scores));
    }

    @Test
    void countsPassedScores() {
        assertEquals(5, Main.passedCount(scores, 10));
    }
}
