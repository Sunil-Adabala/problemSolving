package com.problemsolving.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//Leetcode - 2045. Second Minimum Time to Reach Destination
public class SecondMinimumTimeToReachDestination {
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    HashMap<Integer, ArrayList<Integer>> visitedTimes = new HashMap<>();

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        int currTime = 0;
        int res = -1;

        constructAdjList(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int vertex = queue.poll();
                if(vertex == n){
                    if(res != -1){
                        return currTime;
                    }
                    res = currTime;
                }

                ArrayList<Integer> adjVertices = adjList.get(vertex);
                for(int neighbour : adjVertices){
                    ArrayList<Integer> adjVisTimes = visitedTimes.get(neighbour);
                    int adjVisTimesSize = adjVisTimes.size();
                    if(adjVisTimesSize == 0 || (adjVisTimesSize == 1 && adjVisTimes.get(0) != currTime)){
                        adjVisTimes.add(currTime);
                        queue.add(neighbour);
                    }
                }
            }
            if((currTime / change) % 2 == 1){
                currTime += change - (currTime % change);
            }
            currTime += time;

        }

        return -1;
    }

    private void constructAdjList(int n, int[][] edges){
        for(int i = 0; i <= n; i += 1){
            adjList.add(new ArrayList<>());
            visitedTimes.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }


    }
}
