package baseball.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    @Test
    void 여러공_생성() {
        int[] numbers = new int[]{1,2,3};
        Balls balls = new Balls(createBalls(numbers));

        assertThat(balls).isNotNull();
    }

    @Test
    void 중복_예외() {
        int[] numbers = new int[]{1,1,3};

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Balls(createBalls(numbers)));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,4})
    void 공_개수_예외(int numberSize) {
        int[] numbers = createIntegerArray(numberSize);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Balls(createBalls(numbers)));
    }

    private int[] createIntegerArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = i + 1;
        }
        return numbers;
    }
    private List<Ball> createBalls(int[] numbers) {
        List<Integer> numberList = new ArrayList<>();
        for (int number : numbers) {
            numberList.add(number);
        }
        return createBalls(numberList);
    }

    private List<Ball> createBalls(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        for (Integer number : numbers) {
            balls.add(new Ball(number));
        }
        return balls;
    }
}
