import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Dec01 {
    public Integer getMax() {
        // get max
        List<Integer> calories = createReducedList();
        return Collections.max(calories);
    }

    public Integer getTopThreeTotal() {
        List<Integer> calories = createReducedList();
        List<Integer> sortedCalories = calories.stream().sorted(Comparator.reverseOrder()).toList();
        List<Integer> topThree = new ArrayList<>();
        topThree.add(sortedCalories.get(0));
        topThree.add(sortedCalories.get(1));
        topThree.add(sortedCalories.get(2));
        return topThree.stream().reduce(0, Integer::sum);
    }

    private List<Integer> convertToInt() {
        List<String> allLines = Utils.readFile("resources/dec01.txt");
        // convert from string to integer
        List<Integer> allLinesInt = new ArrayList<>();
        assert allLines != null;
        for (String i: allLines) {
                if (Objects.equals(i, "")) {
                    allLinesInt.add(0);
                } else {
                    allLinesInt.add(Integer.valueOf(i));
                }
            }
            return allLinesInt;
    }

    private List<Integer> createReducedList() {
        List<Integer> allLinesInt = convertToInt();
        // get the index of 0s
        int[] indexes = Stream.of(
                IntStream.of(-1),
                IntStream.range(0, allLinesInt.size()).filter(i -> allLinesInt.get(i).equals(0)),
                IntStream.of(allLinesInt.size())
        )
                .flatMapToInt(ix -> ix)
                .toArray();

        // create subset separated by 0s
        List<List<Integer>> subsets = IntStream.range(0, indexes.length - 1)
                .mapToObj(i -> allLinesInt.subList(indexes[i] + 1, indexes[i + 1])).toList();

        // add each subset
        List<Integer> calories = new ArrayList<>();
        for (List<Integer> i: subsets) {
            int cal = 0;
            for (Integer j: i) {
                cal = i.stream().reduce(0, Integer::sum);
            }
            calories.add(cal);
        }
        return calories;
    }
}
