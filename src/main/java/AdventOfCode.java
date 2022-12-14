package src.main.java;

import src.main.java.dec.*;

public class AdventOfCode {
    public static void main(String[] args) {
        System.out.println("Advent of Code 2022");

        Dec01 dec01 = new Dec01();
        System.out.printf("Dec01 1 %d", dec01.getMax());
        System.out.println();
        System.out.printf("Dec01 2 %d", dec01.getTopThreeTotal());
        System.out.println();

        Dec02 dec02 = new Dec02();
        System.out.printf("Dec02 1 %d", dec02.getTotalScore(1));
        System.out.println();
        System.out.printf("Dec02 2 %d", dec02.getTotalScore(2));
        System.out.println();

        Dec03 dec03 = new Dec03();
        System.out.printf("Dec03 1 %d", dec03.sumPriorities(1));
        System.out.println();
        System.out.printf("Dec03 2 %d", dec03.sumPriorities(2));
        System.out.println();

        Dec04 dec04 = new Dec04();
        System.out.printf("Dec04 1 %d", dec04.containTotal(1));
        System.out.println();
        System.out.printf("Dec04 2 %d", dec04.containTotal(2));
        System.out.println();

        Dec05 dec05 = new Dec05();
        System.out.printf("Dec05 1 %s", dec05.findTopCrates(1));
        System.out.println();
        System.out.printf("Dec05 2 %s", dec05.findTopCrates(2));
        System.out.println();
    }
}
