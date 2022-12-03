import java.util.List;
import java.util.stream.Collectors;

public class Dec02 {
    private List<Integer> getScoresRd1(List<String> strategy) {
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

    private List<Integer> getScoresRd2(List<String> strategy) {
        return strategy.stream().map(item -> {
            return switch (item) {
                case "B X" -> 1;
                case "C X" -> 2;
                case "A X" -> 3;
                case "A Y" -> 4;
                case "B Y" -> 5;
                case "C Y" -> 6;
                case "C Z" -> 7;
                case "A Z" -> 8;
                case "B Z" -> 9;
                default -> 0;
            };
        }).collect(Collectors.toList());
    }

    public Integer getTotalScore(Integer round) {
        List<String> strategy = Utils.readFile("dec02-input.txt");
        assert strategy != null;
        List<Integer> scores;
        if (round.equals(1)) {
            scores = getScoresRd1(strategy);
        } else {
            scores = getScoresRd2(strategy);
        }
        return scores.stream().reduce(0, Integer::sum);
    }


}

/*
A 1 rock
B 2 paper
C 3 scissor

ROUND 1:

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

ROUND 2:

X to lose
Y to draw
Z to win

A X 0+3 3 scissor
A Y 3+1 4 rock
A Z 6+2 8 paper
B X 0+1 1 rock
B Y 3+2 5 paper
B Z 6+3 9 scissor
C X 0+2 2 paper
C Y 3+3 6 scissor
C Z 6+1 7 rock
*/