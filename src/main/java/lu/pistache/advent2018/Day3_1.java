package lu.pistache.advent2018;


import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3_1 {

    List<String> lines;

    public Day3_1() {
        try {
            this.lines = Files.readLines(new File("src/main/resources/day3.txt"), Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Day3_1().process();
    }

    private void process() {
        //parse lines to objects
        Set<Piece> pieces = new HashSet<Piece>();
        lines.stream().forEach(s -> pieces.add(this.createPiece(s)));


        //go through the lines and map it to the whole cloth
        int siz = 1000;
        Set<Piece>[][] cloth = new HashSet[siz][siz];
        for (Piece piece : pieces) {
            //mark the cloth
            for (int i = piece.x; i < piece.x + piece.h; i++) {
                for (int j = piece.y; j < piece.y + piece.w; j++) {
                    if (cloth[i][j] == null) {
                        cloth[i][j] = new HashSet<>();
                    };
                    cloth[i][j].add(piece);
                }
            }
        }

        //go through the whole cloth and where there are 2 or more pieces involved, remove them from the final result
        for (int i = 0; i < siz; i++) {
            for (int j = 0; j < siz; j++) {
                Set<Piece> pieceOfCloth = cloth[i][j];
                if ((pieceOfCloth != null) && (pieceOfCloth.size() > 1)) {
                    pieceOfCloth.stream().forEach(piece -> pieces.remove(piece));
                };
            }
        }
        System.out.println(pieces.toArray()[0]);
    }


    class  Piece {
        int ref;
        int x;
        int y;
        int h;
        int w;


        public Piece(int ref, int x, int y, int h, int w) {
            this.ref = ref;
            this.x = x;
            this.y = y;
            this.h = h;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Piece{" +
                    "ref=" + ref +
                    ", x=" + x +
                    ", y=" + y +
                    ", h=" + h +
                    ", w=" + w +
                    '}';
        }
    }

    private Piece createPiece(String line) {
        int ref = Integer.parseInt(line.split("@")[0].split("#")[1].trim());
        String s = line.split("@")[1];
        String s1 = s.split(":")[0];
        int x = Integer.parseInt(s1.split(",")[0].trim());
        int y = Integer.parseInt(s1.split(",")[1].trim());

        String s2 = s.split(":")[1];
        int h = Integer.parseInt(s2.split("x")[0].trim());
        int w = Integer.parseInt(s2.split("x")[1].trim());
        return new Piece(ref, x, y, h, w);
    }

}