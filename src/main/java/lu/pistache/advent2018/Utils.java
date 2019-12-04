package lu.pistache.advent2018;
import io.vavr.collection.List;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Utils {
    public static String loadInput(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> loadLines(String path) {
        return List.of(loadInput(path).split("\n"));
    }

    public static Stack<Integer> nums(String line) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.stream(line.split("[^\\d]+"))
                .filter(s -> s.length() > 0)
                .map(Integer::valueOf).collect(toList()));
        return stack;
    }

    public static int lastInt(String line) {
        return nums(line).pop();
    }

    public static Integer sum(Collection<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).sum();
    }

    public static Integer max(Collection<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).max().getAsInt();
    }
}

