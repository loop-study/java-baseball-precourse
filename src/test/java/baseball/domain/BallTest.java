package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    @Test
    void 야구공_생성() {
        Ball ball = new Ball(1);

        assertThat(ball).isNotNull();
    }
}
