package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ScoreTest {

    @Test
    void 점수_생성() {
        Score score = new Score();

        assertThat(score).isNotNull();
    }
}
