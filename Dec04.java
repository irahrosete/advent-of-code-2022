import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Dec04 {
    public Integer containTotal(Integer num) {
        List<String> assignments = Utils.readFile("resources/dec04.txt");
        assert assignments != null;
        List<List<String>> cleansed = cleanInput(assignments);
        List<List<Integer>> cleansedInt = convertToNum(cleansed);
        int answer = 0;
        List<Boolean> boolList;
        if (num.equals(1)) {
            boolList = compare(cleansedInt);
        } else {
            boolList = compareAgain(cleansedInt);
        }
        answer = Collections.frequency(boolList, true);
        return answer;
    }

    private List<Boolean> compareAgain(List<List<Integer>> input) {
        return input.stream().map(item -> {
            if ((item.get(0) >= item.get(2)) && (item.get(0) <= item.get(3))) {
                return true;
            } else return (item.get(2) >= item.get(0)) && (item.get(2) <= item.get(1));
        }).collect(Collectors.toList());
    }

    private List<Boolean> compare(List<List<Integer>> input) {
        return input.stream().map(item -> {
            if ((item.get(0) >= item.get(2)) && (item.get(1) <= item.get(3))) {
                return true;
            } else return (item.get(2) >= item.get(0)) && (item.get(3) <= item.get(1));
        }).collect(Collectors.toList());
    }

    private List<List<Integer>> convertToNum(List<List<String>> input) {
        return input.stream().map(pair -> {
            return pair.stream().map(Integer::valueOf).collect(Collectors.toList());
        }).collect(Collectors.toList());
    }

    private List<List<String>> cleanInput(List<String> input) {
        List<List<String>> items = new ArrayList<>();
        for (String item: input) {
            String newItem = item.replace("-", ",");
            items.add(List.of(newItem.split(",")));
        }
        return items;
    }
}

//split on ,
//split on -
//convert to num
//compare 1st
//compare 2nd
