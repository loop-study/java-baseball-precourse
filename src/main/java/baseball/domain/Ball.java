package baseball.domain;


public class Ball {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String ERROR_NUMBER_LANGE = "야구공은 1 ~ 9 의 숫자를 가져야합니다.";

    private final int number;

    public Ball(int number) {
        validationNumberLange(number);
        this.number = number;
    }

    private void validationNumberLange(int number) {
        if (number < MIN_NUMBER
            || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_NUMBER_LANGE);
        }
    }
}
