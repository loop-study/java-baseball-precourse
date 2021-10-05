package baseball.view;

import nextstep.utils.Console;

import java.util.HashSet;
import java.util.Set;

public class InputView {
    private static final String INPUT_THREE_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String ERROR_THREE_NUMBER = "[ERROR] 중복되지 않는 숫자[범위 1 ~ 9] 3자리를 입력해주세요.";
    private static final String ERROR_RESTART_NUMBER = "[ERROR] 잘못 입력하셨습니다.";
    private static final String NUMBER_REGEX = "[1-9]+";
    private static final String RESTART_REGEX = "[1-2]";
    private static final String RESTART_CONDITION = "1";

    public String inputThreeNumber() {

        try {
            System.out.println(INPUT_THREE_NUMBER_MESSAGE);
            String text = Console.readLine();
            validationThreeNumber(text);
            return text;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputThreeNumber();
        }
    }

    public boolean inputRestart() {
        
        try {
            System.out.println(INPUT_RESTART_MESSAGE);
            String text = Console.readLine();
            validationRestart(text);
            return text.equals(RESTART_CONDITION);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputRestart();
        }
    }

    private void validationRestart(String text) {
        if (!text.matches(RESTART_REGEX)) {
            throw new IllegalArgumentException(ERROR_RESTART_NUMBER);
        }
    }

    private void validationThreeNumber(String text) {
        if (text.length() != 3) {
            throw new IllegalArgumentException(ERROR_THREE_NUMBER);
        }

        if (!text.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR_THREE_NUMBER);
        }

        if (!isNumberDuplicate(text)) {
            throw new IllegalArgumentException(ERROR_THREE_NUMBER);
        }
    }

    private boolean isNumberDuplicate(String text) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            numbers.add(Character.getNumericValue(text.charAt(i)));
        }
        return numbers.size() == 3;
    }
}
