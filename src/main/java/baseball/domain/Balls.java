package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
    private static final int BALL_SIZE = 3;
    private static final String ERROR_OVERLAP_BALL = "중복되는 숫자가 있습니다.";


    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        validationOverlapBall(balls);
        this.balls = balls;
    }

    public static Balls of() {
        List<Ball> randomBalls = new ArrayList<>();
        randomBalls.add(Ball.of());
        randomBalls.add(Ball.of());
        randomBalls.add(Ball.of());
        return new Balls(randomBalls);
    }

    private void validationOverlapBall(List<Ball> balls) {
        Set<Ball> ballSet = new HashSet<>(balls);
        if (ballSet.size() != BALL_SIZE) {
            throw new IllegalArgumentException(ERROR_OVERLAP_BALL);
        }
    }
}
