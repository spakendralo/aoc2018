package lu.pistache.advent2018;


import java.util.*;
import java.util.function.Function;

import static java.util.Comparator.comparing;
import static lu.pistache.advent2018.Utils.lastInt;

public class Day4 {
    static Map<Integer, Map<Integer, Integer>> guards = new HashMap<>();

    static void load() {


        List<String> lines = Utils.loadLines("src/main/resources/day4.txt")
                .sorted().asJava();
        int guard = -1;
        int minStartedSleeping = -1;
        int minStartedWakingUp = -1;

        for (String line : lines) {
            if (line.contains("Guard"))
                guard = lastInt(line);
            else if (line.contains("asleep"))
                minStartedSleeping = lastInt(line);
            else if (line.contains("wakes up")) {
                minStartedWakingUp = lastInt(line);
                for (int min = minStartedSleeping; min < minStartedWakingUp; ++min) {
                    if (!guards.containsKey(guard)) {
                        guards.put(guard, new HashMap<>());
                    }
                    Map<Integer, Integer> currentGuard = guards.get(guard);
                    if (!currentGuard.containsKey(min)) {
                        currentGuard.put(min, 1);
                    } else {
                        currentGuard.put(min, currentGuard.get(min) + 1);
                    }
                }
            }
        }
    }

    static int solution(Function<Collection<Integer>, Integer> fun) {
        Optional<Map.Entry<Integer, Map<Integer, Integer>>> guardAndMinutes =
                guards.entrySet().stream()
                        .max(comparing(c -> fun.apply(c.getValue().values())));

        return guardAndMinutes
                .map(e -> {
                    int id = e.getKey();
                    return e.getValue().entrySet().stream()
                            .max(comparing(Map.Entry::getValue))
                            .map(Map.Entry::getKey)
                            .map(minutes -> id * minutes)
                            .orElse(-1);
                })
                .orElse(-1);
    }

    static int solution1() {
        return solution(Utils::sum);
    }

    static int solution2() {
        return solution(Utils::max);
    }

    public static void main(String... args) {
        load();
        System.out.println("Solution1: " + solution1());
        System.out.println("Solution2: " + solution2());
    }
}


