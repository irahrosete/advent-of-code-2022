import java.util.List;
import java.util.stream.Collectors;

public class Dec02 {
    private List<Integer> getScores(List<String> strategy) {
        return strategy.stream().map(item -> {
            return switch (item) {
                case "B X" -> 1;
                case "C Y" -> 2;
                case "A Z" -> 3;
                case "A X" -> 4;
                case "B Y" -> 5;
                case "C Z" -> 6;
                case "C X" -> 7;
                case "A Y" -> 8;
                case "B Z" -> 9;
                default -> 0;
            };
        }).collect(Collectors.toList());
    }

    public Integer getTotalScore() {
        List<String> strategy = Utils.readFile("dec02-input.txt");
        assert strategy != null;
        List<Integer> scores = getScores(strategy);
        return scores.stream().reduce(0, Integer::sum);
    }

    public List<Integer> temp() {
        List<String> strategy = Utils.readFile("dec02-input.txt");
        assert strategy != null;
        return getScores(strategy);
    }

}

/*
A 1 rock
B 2 paper
C 3 scissor

X 1 rock
Y 2 paper
Z 3 scissor

lose 0
draw 3
win 6

A X 1+3 4 draw
A Y 2+6 8 win
A Z 3+0 3 lose
B X 1+0 1 lose
B Y 2+3 5 draw
B Z 3+6 9 win
C X 1+6 7 win
C Y 2+0 2 lose
C Z 3+3 6 draw
*/