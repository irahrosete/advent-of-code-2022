import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dec03 {
    public Integer sumPriorities(Integer num) {
        List<String> rucksack = Utils.readFile("resources/dec03.txt");

        List<String> priorities;
        assert rucksack != null;
        if (num.equals(1)) {
            priorities = halfAndFind(rucksack);
        } else {
            priorities = groupToThreeAndFind(rucksack);

        }
        assert priorities != null;
        List<Integer> numPriorities = convertToNum(priorities);
        return numPriorities.stream().reduce(0, Integer::sum);
    }

    private List<String> halfAndFind(List<String> input) {
        return input.stream().map(item -> {
            int half = item.length()/2;
            List<String> pair = new ArrayList<>();
            pair.add(item.substring(0, half));
            pair.add(item.substring(half));

            List<String> pair1 = Arrays.asList(pair.get(0).split(""));
            List<String> pair2 = Arrays.asList(pair.get(1).split(""));
            return findDup(pair1, pair2);
        }).collect(Collectors.toList());
    }

    private String findDup(List<String> input1, List<String> input2) {
        for (String letter1: input1) {
            for (String letter2: input2) {
                if (letter1.equals(letter2)) {
                    return letter1;
                }
            }
        }
        return null;
    }

    private List<String> groupToThreeAndFind(List<String> input) {
        List<List<String>> newList = new ArrayList<>();
        for (int i = 0; i < input.size(); i+=3) {
            List<String> threes = new ArrayList<>();
            threes.add(input.get(i));
            threes.add(input.get(i + 1));
            threes.add(input.get(i + 2));
            newList.add(threes);
        }
        return newList.stream().map(item -> {
            List<String> input1 = Arrays.asList(item.get(0).split(""));
            List<String> input2 = Arrays.asList(item.get(1).split(""));
            List<String> input3 = Arrays.asList(item.get(2).split(""));
            return findDupThrees(input1, input2, input3);
        }).collect(Collectors.toList());
    }

    private String findDupThrees(List<String> input1, List<String> input2, List<String> input3) {
        for (String letter1: input1) {
            for (String letter2: input2) {
                for (String letter3: input3)
                if (letter1.equals(letter2) && (letter2.equals(letter3))) {
                    return letter1;
                }
            }
        }
        return null;
    }

    private List<Integer> convertToNum(List<String> input) {
        return input.stream().map(item -> {
            return switch (item) {
                case "a" -> 1;
                case "b" -> 2;
                case "c" -> 3;
                case "d" -> 4;
                case "e" -> 5;
                case "f" -> 6;
                case "g" -> 7;
                case "h" -> 8;
                case "i" -> 9;
                case "j" -> 10;
                case "k" -> 11;
                case "l" -> 12;
                case "m" -> 13;
                case "n" -> 14;
                case "o" -> 15;
                case "p" -> 16;
                case "q" -> 17;
                case "r" -> 18;
                case "s" -> 19;
                case "t" -> 20;
                case "u" -> 21;
                case "v" -> 22;
                case "w" -> 23;
                case "x" -> 24;
                case "y" -> 25;
                case "z" -> 26;
                case "A" -> 27;
                case "B" -> 28;
                case "C" -> 29;
                case "D" -> 30;
                case "E" -> 31;
                case "F" -> 32;
                case "G" -> 33;
                case "H" -> 34;
                case "I" -> 35;
                case "J" -> 36;
                case "K" -> 37;
                case "L" -> 38;
                case "M" -> 39;
                case "N" -> 40;
                case "O" -> 41;
                case "P" -> 42;
                case "Q" -> 43;
                case "R" -> 44;
                case "S" -> 45;
                case "T" -> 46;
                case "U" -> 47;
                case "V" -> 48;
                case "W" -> 49;
                case "X" -> 50;
                case "Y" -> 51;
                case "Z" -> 52;
                default -> 0;
            };
        }).collect(Collectors.toList());
    }
}
