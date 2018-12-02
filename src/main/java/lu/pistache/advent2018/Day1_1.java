package lu.pistache.advent2018;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class Day1_1 {
    private Stream<String> stream;

    public Day1_1(Stream<String> stream) {
        this.stream = stream;
    }

    public static void main(String[] args) throws IOException {
        Stream<String> stream = Files.lines(Paths.get("src/main/resources/day1-1.txt"));
        Integer sum = stream.map(Integer::parseInt)
                .reduce((integer, integer2) -> integer + integer2)
                .get();
        System.out.println("1 : " + sum);
    }
}
