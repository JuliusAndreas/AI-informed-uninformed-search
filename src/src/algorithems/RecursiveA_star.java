package src.algorithems;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import src.models.State;

/**
 *
 * @author Julius Andreas
 */
public class RecursiveA_star {

    public static State solve(State start,
            SpecialCounter counter, Set<State> visitedList) {
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
        LinkedList<State> children = new LinkedList<>();
        boolean thereWasNotANewChild = true;
        boolean thereWasNotAValidChild = true;
        double bestChildCost = Double.POSITIVE_INFINITY;
        for (State child : start.makeChild()) {
            children.add(child);
            if (child.getTotalCost() <= start.alternative) {
                fringe.add(child);
                thereWasNotAValidChild = false;
            }
        }
        while (!fringe.isEmpty()) {
            State temp = fringe.poll();
            //The checking place of visitedList is changed here.
            thereWasNotANewChild = false;
            counter.incCount();
            if (temp.isFinal()) {
                return temp;
            }
            if (!fringe.isEmpty()) {
                temp.alternative = fringe.peek().getTotalCost();
            } else {
                temp.alternative = start.alternative;
            }
            State result = RecursiveA_star.solve(temp, counter, visitedList);
            if (result == null) {
                return null;
            } else if (result.isFinal()) {
                return result;
            } else if (result == temp) {
                if (temp.getTotalCost() <= start.alternative) {
                    fringe.add(temp);
                }
            }
        }
        if (thereWasNotAValidChild) {
            for (State checkingState : children) {
                if (checkingState.getTotalCost() < bestChildCost) {
                    bestChildCost = checkingState.getTotalCost();
                }
            }
            start.changeTotalCost(bestChildCost);
            return start;
        }
        if ((!thereWasNotAValidChild) && thereWasNotANewChild) {
            return null;
        }
        for (State checkingState : children) {
            if (checkingState.getTotalCost() < bestChildCost) {
                bestChildCost = checkingState.getTotalCost();
            }
        }
        start.changeTotalCost(bestChildCost);
        return start;
    }

}
