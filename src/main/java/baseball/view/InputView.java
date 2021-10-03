package baseball.view;

import nextstep.utils.Console;

import java.util.HashSet;
import java.util.Set;

public class InputView {
    private static final String INPUT_THREE_NUMBER = "숫자를 입력해주세요 : ";
    private static final String ERROR_THREE_NUMBER = "[ERROR] 중복되지 않는 숫자[범위 1 ~ 9] 3자리를 입력해주세요.";
    private static final String NUMBER_REGEX = "[1-9]+";

    public String inputThreeNumber() {
        System.out.println(INPUT_THREE_NUMBER);
        String text = Console.readLine();

        if (!isValidation(text)) {
            System.out.println(ERROR_THREE_NUMBER);
            return inputThreeNumber();
        }
        return text;
    }

    private boolean isValidation(String text) {
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
