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
            finish = endGame(score);
        }
    }

    private boolean endGame(Score score) {
        resultView.printScore(score);
        if (score.isFinish()) {
            resultView.printFinish();
            return true;
        }
        return false;
    }
}
