package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class Balls {

    @Test
    void 여러공_생성() {
        Balls balls = Balls.of();

        assertThat(balls).isNotNull();
    }
}
