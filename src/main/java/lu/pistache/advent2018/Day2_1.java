package lu.pistache.advent2018;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class Day2_1 extends AbstractDay2 {
    public static void main(String[] args) throws IOException {
        System.out.println(new Day2_1().getChecksum());
    }

    public int getChecksum() {
        Pair pairs = lines.stream()
                .map(s -> getCountingPair(s))
                .reduce((pair1, pair2) -> new Pair(pair1.touplets + pair2.touplets, pair1.triplets + pair2.triplets))
                .get();
        return pairs.touplets * pairs.triplets;
    }

    private Pair getCountingPair(String a) {
        Map<String, Long> collect = a.chars()
                .mapToObj(value -> new Integer(value))
                .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));

        int touplesPresent = 0;
        int tripletsPresent = 0;
        for (Long l : collect.values()) {
            if (l == 2) {
                touplesPresent = 1;
            }
            else if (l == 3) {
                tripletsPresent = 1;
            }
        }

        return new Pair(touplesPresent, tripletsPresent);
    }

    class Pair {
        int touplets;
        int triplets;
        public Pair(int touplets, int triplets) {
            this.touplets = touplets;
            this.triplets = triplets;
        }
    }
}
