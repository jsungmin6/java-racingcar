package com.nextstep.racinggame.domain;

import com.nextstep.racinggame.domain.exceptions.InvalidNamesException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.nextstep.racinggame.domain.CarsFixtures.ALL_NOT_MOVED_TEST123_CARS;
import static com.nextstep.racinggame.domain.NameFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsFactoryTests {
    @DisplayName("Name 컬렉션을 인자로 받아 Cars 일급 컬렉션을 생성할 수 있다.")
    @Test
    void createCarsTest() {
        List<Name> names = Arrays.asList(TEST1,TEST2, TEST3);

        assertThat(CarsFactory.createCars(names)).isEqualTo(ALL_NOT_MOVED_TEST123_CARS);
    }

    @DisplayName("인자가 null이거나 빈 컬렉션인 경우 예외가 발생한다.")
    @Test
    void createCarsFailTest() {
        assertThatThrownBy(() -> CarsFactory.createCars(null)).isInstanceOf(InvalidNamesException.class);
        assertThatThrownBy(() -> CarsFactory.createCars(new ArrayList<>())).isInstanceOf(InvalidNamesException.class);
    }
}