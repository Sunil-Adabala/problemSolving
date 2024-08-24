package com.problemsolving;

import com.problemsolving.hard.SecondMinimumTimeToReachDestination;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        runSecondMinimumTimeToReachDestination();

    }

    private static void runSecondMinimumTimeToReachDestination(){
        SecondMinimumTimeToReachDestination secondMinimumTimeToReachDestination = new SecondMinimumTimeToReachDestination();
        //TC - 1
        int n = 5;
        int[][] edges = {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
        int time = 3;
        int change = 5;
        int res = secondMinimumTimeToReachDestination.secondMinimum(n, edges, time, change);
        System.out.println(res);

    }
}