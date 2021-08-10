package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("name");
    }

    @DisplayName("4이상일 경우 전진 테스트")
    @Test
    public void moveAdvanceTest() {
        car.move(new MovingStragey() {
            @Override
            public int carMove() {
                return 1;
            }
        });
        assertThat(car.readCarDistance()).isEqualTo(1);
    }

    @DisplayName("3이하일 경우 정지 테스트")
    @Test
    public void moveStopTest() {
        car.move(new MovingStragey() {
            @Override
            public int carMove() {
                return 0;
            }
        });
        assertThat(car.readCarDistance()).isEqualTo(0);
    }

}