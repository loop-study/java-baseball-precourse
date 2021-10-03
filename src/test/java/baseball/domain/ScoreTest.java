package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("점수 확인")
public class ScoreTest {
    private Balls randomBalls;

    @BeforeEach
    void setUp() {
        randomBalls = Balls.createPlayerBalls("123");
    }

    @Test
    void 점수_생성() {
        Balls inputBalls = Balls.createPlayerBalls("234");
        Score score = Score.of(randomBalls.getBalls(), inputBalls.getBalls());

        assertThat(score).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"123:3", "124:2", "135:1"}, delimiter = ':')
    void 스트라이크_확인(String inputText, int resultStrikeCount) {
        Balls inputBalls = Balls.createPlayerBalls(inputText);
        Score score = Score.of(randomBalls.getBalls(), inputBalls.getBalls());

        assertThat(score.getStrike()).isEqualTo(resultStrikeCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"312:3", "234:2", "345:1"}, delimiter = ':')
    void 볼_확인(String inputText, int resultBallCount) {
        Balls inputBalls = Balls.createPlayerBalls(inputText);
        Score score = Score.of(randomBalls.getBalls(), inputBalls.getBalls());

        assertThat(score.getBall()).isEqualTo(resultBallCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:true", "124:false", "135:false"}, delimiter = ':')
    void 게임종료_여부_확인(String inputText, boolean result) {
        Balls inputBalls = Balls.createPlayerBalls(inputText);
        Score score = Score.of(randomBalls.getBalls(), inputBalls.getBalls());

        assertThat(score.isPlayerWin()).isEqualTo(result);
    }
}
