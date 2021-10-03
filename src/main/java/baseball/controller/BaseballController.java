package baseball.controller;

import baseball.view.InputView;

public class BaseballController {
    private InputView inputView;

    public BaseballController() {
        inputView = new InputView();
    }

    public void run() {
        String inputText = inputView.inputThreeNumber();
    }
}
