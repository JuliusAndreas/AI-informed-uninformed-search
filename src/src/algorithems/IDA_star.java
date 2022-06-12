package src.algorithems;

import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import src.models.State;

/**
 *
 * @author Julius Andreas
 */
public class IDA_star {

    public static void solve(State start) {
        int cuttoff = 1;
        while (true) {
            boolean flag = false;
            int count = 0;
            if (start.isFinal()) {
                start.print();
                return;
            }

            Set<State> visitedList = new TreeSet<>();
            Stack<State> fringe = new Stack<>();
            fringe.add(start);
            while (!fringe.isEmpty()) {
                State temp = fringe.pop();
                
                    if (temp.getTotalCost() > cuttoff) {
                        continue;
                    }
                    visitedList.add(temp);
                    count++;
                    if (temp.isFinal()) {
                        temp.print();
                        System.out.println("node count = " + count);
                        System.out.println("answer found at cuttoff = " + cuttoff);
                        return;
                    }
                    for (State child : temp.makeChild()) {
                        if (child.getTotalCost() > cuttoff) {
                            continue;
                        }
                        fringe.add(child);
                    }
                
            }
            cuttoff++;
        }
    }
}
