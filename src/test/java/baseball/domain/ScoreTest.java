package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ScoreTest {
    private Balls randomBalls;

    @BeforeEach
    void setUp() {
        randomBalls = Balls.createInputBalls("123");
    }

    @Test
    void 점수_생성() {
        Balls inputBalls = Balls.createInputBalls("234");
        Score score = Score.of(randomBalls.getBalls(), inputBalls.getBalls());

        assertThat(score).isNotNull();
    }
}
