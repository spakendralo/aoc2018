package lu.pistache.advent2018;


import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AbstractDay2 {
    List<String> lines;

    public AbstractDay2() {
        try {
            this.lines = Files.readLines(new File("src/main/resources/day2.txt"), Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
