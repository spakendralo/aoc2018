package lu.pistache.advent2019;

import io.vavr.collection.Iterator;
import io.vavr.collection.List;
import lu.pistache.advent2018.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Day1 {

    static int fuel = 0;

    public static void main(String[] args) throws IOException {



        Stream<String> strings = Files.lines(Paths.get("src/main/resources/advent2019/day1.txt"));
        int s = strings.map(Integer::parseInt)
                .map((x) -> calcul(x))
                .reduce((x, y) -> x + y).get();
        System.out.println("First part:" + s);


        List<String> lines = Utils.loadLines("src/main/resources/advent2019/day1.txt");
        lines.forEach(x -> calculateSingleFuel(Integer.parseInt(x)));
        System.out.println("Second part:" + fuel);

    }

    private static void calculateSingleFuel(int weight) {
        fuel += recursiveCalculate(weight);
    }

    private static int recursiveCalculate(int weight) {
        int stepWeight = 0;
        int fuelNeededForStep = calcul(weight);
        if (fuelNeededForStep >= 9) {
            stepWeight = recursiveCalculate(fuelNeededForStep);
        }
        else {
            stepWeight = fuelNeededForStep;
            return stepWeight;
        }
        stepWeight += fuelNeededForStep;
        return stepWeight;
    }

    private static int calcul(int weight) {
        return (weight / 3) - 2;
    }
}
