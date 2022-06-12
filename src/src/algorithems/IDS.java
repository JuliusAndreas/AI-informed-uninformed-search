package src.algorithems;

import src.models.State;

/**
 *
 * @author Julius Andreas
 */
public class IDS {

    public static void solve(State start) {
        int limit = 1;
        while (true) {
            StatusReport report = DLS.solve(start, limit);
            if (report == StatusReport.failure) {
                System.out.println("Not found");
                break;
            }
            if (report == StatusReport.success) {
                break;
            } else {
                limit++;
            }
        }

    }

}
