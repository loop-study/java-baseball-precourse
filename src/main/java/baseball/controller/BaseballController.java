package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Score;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballController {
    private InputView inputView;
    private ResultView resultView;
    private Balls randomBalls;

    public BaseballController() {
        inputView = new InputView();
        resultView = new ResultView();
        randomBalls = Balls.of();
    }

    public void run() {
        boolean finish = false;

        while (!finish) {
            Balls playerBalls = Balls.createPlayerBalls(inputView.inputThreeNumber());
            Score score = Score.of(playerBalls.getBalls(), randomBalls.getBalls());
            finish = isGameFinish(score);
        }
    }

    private boolean isGameFinish(Score score) {
        resultView.printScore(score);
        if (score.isPlayerWin()) {
            resultView.printFinish();
            return isRestart();
        }
        return false;
    }

    private boolean isRestart() {
        if (inputView.inputRestart()) {
            randomBalls = Balls.of();
            return false;
        }
        return true;
    }
}
