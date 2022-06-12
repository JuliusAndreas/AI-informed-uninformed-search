package src.algorithems;

import src.models.State;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class DFS {

    public static void solve(State start) {
        int count = 0;
        if (start.isFinal()) {
            start.print();
            return;
        }

        Set<State> visitedList = new TreeSet<>();
        visitedList.add(start);
        Stack<State> fringe = new Stack<>();
        
        fringe.add(start);

        while (!fringe.isEmpty()) {
            State temp = fringe.pop();
            count++;
            if (temp.isFinal()) {
                temp.print();
                System.out.println("node count = " + count);
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

    }

}
