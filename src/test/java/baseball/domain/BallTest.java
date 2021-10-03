package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    @Test
    void 공_생성() {
        Ball ball = new Ball();

        assertThat(ball).isNotNull();
    }
}
