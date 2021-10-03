package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    @Test
    void 여러공_생성() {
        Balls balls = Balls.of();

        assertThat(balls).isNotNull();
    }

    @Test
    void 중복_예외() {
        int[] numbers = new int[]{1,1,3};

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Balls(createBalls(numbers)));
    }

    private List<Ball> createBalls(int[] numbers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            balls.add(new Ball(numbers[i]));
        }
        return balls;
    }
}
