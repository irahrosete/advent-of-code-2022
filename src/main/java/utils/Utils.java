package src.main.java.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static List<String> readFile(String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<List<Integer>> convertToNum(List<List<String>> input) {
        return input.stream().map(pair -> {
            return pair.stream().map(Integer::valueOf).collect(Collectors.toList());
        }).collect(Collectors.toList());
    }
}
