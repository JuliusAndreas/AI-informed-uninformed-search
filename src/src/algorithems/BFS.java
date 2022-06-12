package src.algorithems;

import src.models.State;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class BFS {
    
    static State goalState;
    static boolean wasThereAnAnswer = true;

    public static void solve(State start) {

        int count = 0;
        if (start.isFinal()) {
            BFS.goalState = start;
            start.print();
            return;
        }

        Set<State> visitedList = new TreeSet<>();
        visitedList.add(start);
        Queue<State> fringe = new LinkedList<>();
        
        fringe.add(start);

        while (!fringe.isEmpty()) {
            State temp = fringe.poll();
            count++;
            if (temp.isFinal()) {
                temp.print();
                System.out.println("node count = " + count);
                BFS.goalState = temp;
                return;
            }

            for (State child : temp.makeChild()) {
                if (!visitedList.contains(child)) {
                    visitedList.add(child);
                    fringe.add(child);
                }
            }


        }

        System.out.println("not found");
        wasThereAnAnswer = false;
    }

}
