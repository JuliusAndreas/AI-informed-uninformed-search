package src.algorithems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import src.models.State;

/**
 *
 * @author Julius Andreas
 */
public class RBFS {

    public static void solve(State start) {
        start.alternative = Double.POSITIVE_INFINITY;
        Set<State> visitedList = new TreeSet<>();
        SpecialCounter counter = new SpecialCounter();
        State finalResult = RecursiveA_star.solve(start, counter, visitedList);
        if (finalResult == null) {
            System.out.println("not found");
        } else if (finalResult.isFinal()) {
            finalResult.print();
            System.out.println("node count = " + counter.getCount());
        }
    }
}
