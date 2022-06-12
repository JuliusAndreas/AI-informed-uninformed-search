package src.algorithems;

import java.util.Comparator;
import src.models.State;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class A_star {

    public static void solve(State start) {
        int count = 0;
        if (start.isFinal()) {
            start.print();
            return;
        }
        Set<State> visitedList = new TreeSet<>();
        /*We use a comparator to have our states sorted by f(n) in priority
        queue*/
        Comparator<State> comparator = new Comparator<State>() {
            @Override
            public int compare(State o1, State o2) {
                if (o1.getTotalCost() == o2.getTotalCost()) {
                    return 0;
                } else {
                    return o1.getTotalCost() > o2.getTotalCost() ? 1 : -1;
                }
            }
        };
        Queue<State> fringe = new PriorityQueue<>(comparator);
        fringe.add(start);
        while (!fringe.isEmpty()) {
            State temp = fringe.poll();
            //The checking place of visitedList is changed here.
            if (visitedList.contains(temp)) { 
                continue;
            } else {
                visitedList.add(temp);
                count++;
                if (temp.isFinal()) {
                    temp.print();
                    System.out.println("node count = " + count);
                    return;
                }

                for (State child : temp.makeChild()) {
                    fringe.add(child);
                }
            }
        }
        System.out.println("not found");
    }

}
