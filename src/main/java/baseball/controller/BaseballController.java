package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Score;
import baseball.view.InputView;

public class BaseballController {
    private InputView inputView;
    private Balls randomBalls;

    public BaseballController() {
        inputView = new InputView();
        randomBalls = Balls.of();
    }

    public void run() {
        String inputText = inputView.inputThreeNumber();
        Balls playerBalls = Balls.createPlayerBalls(inputText);

        Score score = Score.of(playerBalls.getBalls(), randomBalls.getBalls());
    }
}
