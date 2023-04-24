package racingcar;

import java.util.List;
import java.util.*;

public class RaceRecord {

    private final Map<String,Integer> result = new HashMap<>();

    public RaceRecord(Cars cars) {
        for (Car car : cars.getCars()) {
            result.put(car.getName(),car.getDistance());
        }
    }

    public RaceRecord(List<Car> carList) {
        for (Car car : carList) {
            result.put(car.getName(),car.getDistance());
        }
    }

    public Map<String, Integer> getResult() {
        return result;
    }
}
