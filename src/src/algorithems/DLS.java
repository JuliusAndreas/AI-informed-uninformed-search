package src.algorithems;

import src.models.State;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class DLS {

    public static StatusReport solve(State start, int limit) {
        boolean flag = false;
        int count = 0;
        if (start.isFinal()) {
            start.print();
            return StatusReport.success;
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
                return StatusReport.success;
            }

            for (State child : temp.makeChild()) {
                if (child.getDepth() > limit) {
                    break;
                }
//                if (!visitedList.contains(child)) {
                    if (child.getDepth() == limit) {
                        flag = true;
                    }
//                    visitedList.add(child);
                    fringe.add(child);
//                }

            }
            
        }
        if(!flag){
            return StatusReport.failure;
        }
        
        return StatusReport.hope;
    }

}
