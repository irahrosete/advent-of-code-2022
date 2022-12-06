package src.main.java.dec;

import src.main.java.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static src.main.java.utils.Utils.convertToNum;

public class Dec05 {
    public StringBuilder findTopCrates(int num) {
        List<String> allLines = Utils.readFile("src/main/resources/dec05.txt");
        assert allLines != null;
        List<List<Character>> crates = buildCrates();
        List<List<Integer>> instructions = makeInstructions(allLines.subList(10, allLines.size()));
        List<List<Character>> result = moveCrates(crates, instructions, num);
        StringBuilder answer = new StringBuilder();
        for (List<Character> item: result) {
            answer.append(item.get(0));
        }
        return answer;
    }

    private List<List<Character>> moveCrates(List<List<Character>> crates, List<List<Integer>> instructions, int num) {
        for (List<Integer> item: instructions) {
            int from = item.get(1)-1;
            int to = item.get(2)-1;
            List<Character> crateFrom = crates.get(from);
            List<Character> crateTo = crates.get(to);

            int sub = item.get(0);
            List<Character> cratesToMove = crateFrom.subList(0, sub);
            if (num == 1) {
                Collections.reverse(cratesToMove);
            }
            crateTo.addAll(0, cratesToMove);
            crateFrom.subList(0, sub).clear();

            crates.set(from, crateFrom);
            crates.set(to, crateTo);
        }
        return crates;
    }

    private List<List<Integer>> makeInstructions(List<String> input) {
        List<List<String>> instructions = new ArrayList<>();
        for (String item: input) {
            List<Integer> ins = new ArrayList<>();
            String regex = "[^\\d ]| \\.$";
            String s = item.replaceAll(regex,"").trim();
            List<String> stringArr = List.of(s.split("  "));
            instructions.add(stringArr);
        }
        return convertToNum(instructions);
    }

    private List<List<Character>> buildCrates() {
        List<String> allLines = Utils.readFile("src/main/resources/dec05.txt").subList(0,8);
        List<String> newAllLines = new ArrayList<>();
        for (String item: allLines) {
            if (item.length() < 35) {
                String s = item + " ".repeat(35 - item.length());
                newAllLines.add(s);
            } else {
                newAllLines.add(item);
            }
        }
        List<List<Character>> allCrates = new ArrayList<>();
        for (int i = 1; i < newAllLines.get(0).length(); i+=4) {
            List<Character> crate = new ArrayList<>();
            for (String item: newAllLines ) {
                if (!(item.charAt(i) == ' ')) {
                    crate.add(item.charAt(i));
                }
            }
            allCrates.add(crate);
        }
        return allCrates;
    }
}
