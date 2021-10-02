package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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


}
