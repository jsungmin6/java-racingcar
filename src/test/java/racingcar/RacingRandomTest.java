package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static racingcar.RacingRandom.*;

public class RacingRandomTest {
    @Test
    void random() {
        RacingRandom random = getInstance();
        for (int i = 0; i < 100; i++) {
            Assertions.assertThat(isActual(random.getRandomNo())).isTrue();
        }
    }

    private boolean isActual(int number) {
        return number <= LIMIT && number >= 0;
    }
}
