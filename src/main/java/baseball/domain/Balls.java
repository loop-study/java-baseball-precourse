package baseball.domain;

import java.util.*;

public class Balls {
    private static final int BALL_SIZE = 3;
    private static final String ERROR_OVERLAP_BALL = "중복되는 숫자가 있습니다.";
    private static final String ERROR_BALL_SIZE = "중복되는 숫자가 있습니다.";

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        validationBallsSize(balls);
        validationOverlapBall(balls);
        this.balls = balls;
    }

    public static Balls createInputBalls(String inputNumbers) {
        Set<Ball> randomBalls = new HashSet<>();
        for (int i = 0; i < inputNumbers.length(); i++) {
            int number = Character.getNumericValue(inputNumbers.charAt(i));
            randomBalls.add(new Ball(number));
        }
        return new Balls(new ArrayList<>(randomBalls));
    }

    public static Balls of() {
        Set<Ball> randomBalls = new HashSet<>();
        while (randomBalls.size() != BALL_SIZE) {
            randomBalls.add(Ball.of());
        }
        return new Balls(new ArrayList<>(randomBalls));
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    private void validationBallsSize(List<Ball> balls) {
        if (balls.size() != BALL_SIZE) {
            throw new IllegalArgumentException(ERROR_BALL_SIZE);
        }
    }

    private void validationOverlapBall(List<Ball> balls) {
        Set<Ball> ballSet = new HashSet<>(balls);
        if (ballSet.size() != balls.size()) {
            throw new IllegalArgumentException(ERROR_OVERLAP_BALL);
        }
    }
}
