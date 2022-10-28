package refactoringracingcar.controller;

import refactoringracingcar.domain.Car;
import refactoringracingcar.domain.RacingCarGame;
import refactoringracingcar.view.InputView;
import refactoringracingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class CarController {

    public void startGame() {
        String[] carNames = InputView.enterCarName();
        int gameNumber = InputView.enterGameNumber();

        enterCarInformation(carNames, gameNumber);
    }

    private void enterCarInformation(String[] carNames, int gameNumber) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        progressRacingCarGame(cars, gameNumber);
    }

    private void progressRacingCarGame(List<Car> cars, int gameNumber) {
        RacingCarGame racingCarGame = new RacingCarGame(cars);
        for (int i = 0; i < gameNumber; i++) {
            racingCarGame.raceCarGame();
            ResultView.printGameStatus(cars);
        }
        ResultView.printWinner(cars);
    }

}