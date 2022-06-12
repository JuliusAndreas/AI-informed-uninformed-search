package src.algorithems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import src.models.State;

/**
 *
 * @author Julius Andreas
 */
public class BDS {

    static State finalState;

    public static void solve(State start) {
        BFS.solve(start);
        if (!BFS.wasThereAnAnswer) {
            return;
        }
        int minDepth = Integer.MAX_VALUE;
        State savedState = null;
        System.out.println("That was BFS, Now BDS:");
        BDS.finalState = new State(BFS.goalState.getBoard());

        int straightCount = 0;
        int reversedCount = 0;
        Set<State> straightVisitedList = new TreeSet<>();
        Set<State> reversedVisitedList = new TreeSet<>();
        straightVisitedList.add(start);
        reversedVisitedList.add(finalState);
        Queue<State> straightFringe = new LinkedList<>();
        Queue<State> reversedFringe = new LinkedList<>();
        straightFringe.add(start);
        reversedFringe.add(finalState);
        while (!straightFringe.isEmpty() && !reversedFringe.isEmpty()) {
            State strTemp = straightFringe.poll();
            State revTemp = reversedFringe.poll();
            straightCount++;
            reversedCount++;
            if (reversedFringe.contains(strTemp)) {
                strTemp.print();
                for (State state : reversedFringe) {
                    if (state.equals(strTemp)) {
                        if (state.getDepth() < minDepth) {
                            minDepth = state.getDepth();
                            savedState = state;
                        }
                    }
                }
                savedState.reversePrint();
                int sum = reversedCount + straightCount;
                System.out.println("node count = " + sum);
                return;
            }
            for (State child : strTemp.makeChild()) {
                if (!straightVisitedList.contains(child)) {
                    straightVisitedList.add(child);
                    straightFringe.add(child);
                }
            }
            if (straightFringe.contains(revTemp)) {
                for (State state : straightFringe) {
                    if (state.equals(revTemp)) {
                        if (state.getDepth() < minDepth) {
                            minDepth = state.getDepth();
                            savedState = state;
                        }
                    }
                }
                savedState.print();
                revTemp.reversePrint();
                int sum = reversedCount + straightCount;
                System.out.println("node count = " + sum);
                return;
            }
            for (State child : revTemp.makeReversedChild()) {
                if (!reversedVisitedList.contains(child)) {
                    reversedVisitedList.add(child);
                    reversedFringe.add(child);
                }
            }
        }

    }

}
