
import src.algorithems.BFS;
import src.models.Board;
import src.models.Cube;
import src.models.State;

import java.util.Scanner;
import src.algorithems.A_star;
import src.algorithems.BDS;
import src.algorithems.DFS;
import src.algorithems.IDA_star;
import src.algorithems.IDS;
import src.algorithems.RBFS;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(" ");
        String[] cubeStart = scanner.nextLine().split(" ");
        StringBuilder map = new StringBuilder();
        int length, height;
        int x, y;
        x = Integer.parseInt(cubeStart[0]) - 1;
        y = Integer.parseInt(cubeStart[1]) - 1;
        height = Integer.parseInt(size[0]);
        length = Integer.parseInt(size[1]);
        for (int i = 0; i < height; i++) {
            map.append(scanner.nextLine());
        }

        State start = new State(new Board(length, height, map.toString(), new Cube(x, y)));
//        BDS.solve(start);
//        BFS.solve(start);
//        DFS.solve(start);
//        IDS.solve(start);
//        A_star.solve(start);
//        IDA_star.solve(start);
        RBFS.solve(start);
    }

    /*Attention!!! If you are using BDS, you will get two seperate number of done actions
    and lists of actions, remember the first number and its list of actions below
    is for reaching goalstate (the state in the middle) from initial state; and 
    the second number and its list of actions below is for reaching goalstate
    (the state in the middle) from target state (which we know from doing BFS
    before starting BDS)
     */
 /*
1 3
1 1
...

1 3
1 3
...

3 1
1 1
.
.
.

3 1
3 1
.
.
.

     */

 /*
3 3
1 1
...
*..
...

3 3
3 3
..*
...
...

5 5
3 3
**.**
**.**
.....
**.**
**.**

5 5
1 1
.....
.....
.....
.....
.....

3 7
1 1
...*...
...*...
.......

4 7
1 1
...*...
...*...
.......
...*...


     */

 /*

5 5
3 3
.*.**
**.**
.....
**.**
**.**

     */
}
