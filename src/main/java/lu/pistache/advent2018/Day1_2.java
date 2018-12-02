package lu.pistache.advent2018;

import java.io.*;
import java.util.*;

public class Day1_2 {
    public static void main(String[] args) throws IOException {
        Set freqs = new HashSet();
        List<Integer> integers = readFile(); //assume we can keep all the file in memory
        int result = 0;
        boolean found = false;
        while (!found) {
            System.out.print(".");
            for (Integer integer : integers) {
                result += integer;
                if (freqs.contains(result)) {
                    System.out.println();
                    System.out.println("2 : " + result);
                    found = true;
                    break;
                } else {
                    freqs.add(result);
                }
            }
        }
    }

    private static List<Integer> readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/day1-1.txt"));
        String thisLine;
        List<Integer> lines = new ArrayList<>();
        while ((thisLine = br.readLine()) != null) {
            lines.add(Integer.parseInt(thisLine));
        }
        return lines;
    }
}
