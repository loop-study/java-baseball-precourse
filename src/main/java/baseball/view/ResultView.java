package baseball.view;

import baseball.domain.Score;

public class ResultView {
    private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다!";
    private static final String GAME_END = "게임 끝";

    public void printFinish() {
        System.out.println(THREE_STRIKE_MESSAGE);
        System.out.println(GAME_END);
    }

    public void printScore(Score score) {
        System.out.println(scoreToString(score));
    }

    private String scoreToString(Score score) {
        StringBuilder builder = new StringBuilder();

        strikeToString(builder, score.getStrike());
        ballToString(builder, score.getBall());

        if (builder.length() == 0) {
            builder.append("낫싱");
        }
        return builder.toString();
    }

    private void strikeToString(StringBuilder builder, int strike) {
        if (strike > 0) {
            builder.append(String.format("%d스트라이크 ", strike));
        }
    }

    private void ballToString(StringBuilder builder, int ball) {
        if (ball > 0) {
            builder.append(String.format("%d볼", ball));
        }
    }

}
