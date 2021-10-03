package baseball.view;

import nextstep.utils.Console;

import java.util.HashSet;
import java.util.Set;

public class InputView {
    private static final String INPUT_THREE_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String ERROR_THREE_NUMBER = "[ERROR] 중복되지 않는 숫자[범위 1 ~ 9] 3자리를 입력해주세요.";
    private static final String NUMBER_REGEX = "[1-9]+";
    private static final String RESTART_REGEX = "[1-2]";
    private static final String RESTART_CONDITION = "1";

    public String inputThreeNumber() {
        System.out.println(INPUT_THREE_NUMBER_MESSAGE);
        String text = Console.readLine();

        if (!isValidationThreeNumber(text)) {
            System.out.println(ERROR_THREE_NUMBER);
            return inputThreeNumber();
        }
        return text;
    }

    public boolean inputRestart() {
        System.out.println(INPUT_RESTART_MESSAGE);
        String text = Console.readLine();

        if (!text.matches(RESTART_REGEX)) {
            System.out.println(ERROR_THREE_NUMBER);
            return inputRestart();
        }
        return text.equals(RESTART_CONDITION);
    }

    private boolean isValidationThreeNumber(String text) {
        if (text.length() != 3) {
            return false;
        }

        if (!text.matches(NUMBER_REGEX)) {
            return false;
        }

        return isNumberDuplicate(text);
    }

    private boolean isNumberDuplicate(String text) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            numbers.add(Character.getNumericValue(text.charAt(i)));
        }
        return numbers.size() == 3;
    }
}
