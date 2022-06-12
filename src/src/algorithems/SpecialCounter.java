package src.algorithems;

/**
 *
 * @author Julius Andreas
 */

/*This class is used just for counting RBFS nodes because a simple variable can not
be used for such purpose
*/
public class SpecialCounter {

    private int count = 0;

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    public void incCount() {
        this.count++;
    }

}
