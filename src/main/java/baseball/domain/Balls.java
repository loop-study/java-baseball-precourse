package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls of() {
        List<Ball> randomBalls = new ArrayList<>();
        randomBalls.add(Ball.of());
        randomBalls.add(Ball.of());
        randomBalls.add(Ball.of());
        return new Balls(randomBalls);
    }
}
