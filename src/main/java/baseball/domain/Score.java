package baseball.domain;

import java.util.List;

public class Score {
    private static final Integer ONE = 1;
    private static final Integer ZERO = 0;
    private int strike;
    private int ball;

    private Score(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public static Score of(List<Ball> playerBalls, List<Ball> randomBalls) {
        int strikeCount = strikeZone(playerBalls, randomBalls);
        int ballCount = ballZone(playerBalls, randomBalls);

        return new Score(strikeCount, ballCount);
    }

    private static int strikeZone(List<Ball> playerBalls, List<Ball> randomBalls) {
        int count = 0;
        for (int i = 0; i < playerBalls.size(); i++) {
            count += isStrike(playerBalls.get(i), randomBalls.get(i));
        }
        return count;
    }

    private static int isStrike(Ball playerBall, Ball randomBall) {
        if (playerBall.equals(randomBall)) {
            return ONE;
        };
        return ZERO;
    }

    private static int ballZone(List<Ball> playerBalls, List<Ball> randomBalls) {
        int count = 0;
        for (int i = 0; i < playerBalls.size(); i++) {
            count += isBall(playerBalls.get(i), randomBalls.get(i), randomBalls);
        }
        return count;
    }

    private static int isBall(Ball playerBall, Ball randomBall, List<Ball> randomBalls) {
        if (!playerBall.equals(randomBall)
            && randomBalls.contains(playerBall)) {
            return ONE;
        };
        return ZERO;
    }
}
