package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("문자열 테스트")
public class StringTest {


    @Test
    void 문자열_나누기_1() {
        String text = "1,2";
        String[] split = text.split(",");

        assertThat(split).containsExactly("1", "2");
    }

    @Test
    void 문자열_나누기_2() {
        String text = "1";
        String[] split = text.split(",");

        assertThat(split).hasSize(1);
        assertThat(split).containsExactly("1");
    }

    @Test
    void 문자_제거() {
        String text = "(1,2)";
        int startIndex = text.indexOf("(")+1;
        int lastIndex = text.indexOf(")");

        String result = text.substring(startIndex, lastIndex);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("특정 위치 문자 가져오기")
    @Test
    void 문자_가져오기() {
        String text = "abc";

        assertAll(
                ()-> assertEquals(text.charAt(0), 'a'),
                ()-> assertEquals(text.charAt(1), 'b'),
                ()-> assertEquals(text.charAt(2), 'c'),
                ()-> assertThatThrownBy(() -> {
                    text.charAt(3);
                }).isInstanceOf(IndexOutOfBoundsException.class)
                        .hasMessageContaining("String index out of range: 3")
        );
    }
}
