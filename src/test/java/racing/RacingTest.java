package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.*;
import utility.NumberHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author han
 */
class RacingTest {

    @Test
    @DisplayName(value = "플레이")
    void play() {
        Racing racing = new Racing(getUsers(NumberHelper.getRandomValue(3) + 1), NumberHelper.getRandomValue(5) + 1);

        Winner play = racing.play(new Random());
        play.getWinners().forEach(car -> assertThat(car.getStep()).isGreaterThanOrEqualTo(0));
    }

    @ParameterizedTest(name = "예상된 랜덤값을 통한 플레이")
    @MethodSource("indexCarsAndResultProvider")
    void playWithExpectedRandomValue(int i, int j, int k) {
        Racing racing = new Racing(getUsers(3), 3);
        Winner winner = racing.play(new DeterministicRandom());

        RacingHistory racingHistory = winner.getRacingHistory();

        Queue<RacingCar> data = racingHistory.getData();
        RacingCar racingCar = new ArrayList<>(data).get(i);
        assertThat(racingCar.getCars().get(j).getStep()).isEqualTo(k);
    }

    @ParameterizedTest(name = "잘못 생성 시, 에러를 던진다")
    @MethodSource("carSAndAttemptsProvider")
    void throwExceptionWhenCreated(int cars, int attempts) {
        assertThatThrownBy(() -> new Racing(getUsers(cars), attempts)).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> indexCarsAndResultProvider() {
        return Stream.of(
            Arguments.arguments(0, 0, 0),
            Arguments.arguments(0, 1, 0),
            Arguments.arguments(0, 2, 0),
            Arguments.arguments(1, 0, 0),
            Arguments.arguments(1, 1, 1),
            Arguments.arguments(1, 2, 1),
            Arguments.arguments(2, 0, 1),
            Arguments.arguments(2, 1, 2),
            Arguments.arguments(2, 2, 2)
        );
    }

    static Stream<Arguments> carSAndAttemptsProvider() {
        return Stream.of(
            Arguments.arguments(-1, 1),
            Arguments.arguments(1, -1),
            Arguments.arguments(0, 0)
        );
    }

    List<String> getUsers(int number) {
        return IntStream.rangeClosed(1, number)
            .mapToObj(String::valueOf)
            .collect(Collectors.toList());
    }
}