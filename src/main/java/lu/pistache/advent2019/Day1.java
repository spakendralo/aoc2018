package lu.pistache.advent2019;

import io.vavr.collection.Iterator;
import io.vavr.collection.List;
import lu.pistache.advent2018.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Day1 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Utils.loadLines("src/main/resources/advent2019/day1.txt");
        int carb = 0;
        for (String line : lines) {
            carb += ((int) (Integer.parseInt(line) / 3)) - 2;
        }
        System.out.println(carb);


        Stream<String> strings = Files.lines(Paths.get("src/main/resources/advent2019/day1.txt"));
        int s = strings.map(Integer::parseInt).map((x) -> ((int) x / 3) - 2).reduce((x, y) -> x + y).get();
        System.out.println(s);

    }
}
