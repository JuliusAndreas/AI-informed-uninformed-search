package src.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class State implements Comparable<State> {

    public double alternative;
    private double totalCost;
    private int depth;
    private Board board;
    private State parent;
    private int action;
    //0 -> up
    //1 -> down
    //2 -> left
    //3 -> right

    public State(Board board) {
        this.board = board;
        this.depth = 0;
        this.parent = null;
        this.totalCost = getHeuristic() + this.depth;
    }

    private State(int depth, Board board, State parent, int action) {
        this.depth = depth + 1;
        this.board = board;
        this.parent = parent;
        this.action = action;
        this.totalCost = getHeuristic() + this.depth;
    }

    public ArrayList<State> makeChild() {
        ArrayList<State> states = new ArrayList<>();
        if (getBoard().getCube().isStand()) {
            if (getBoard().getCube().getX() >= 2) {
                Board tempBoard = getBoard().moveUp();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 0));
                }
            }
            if (getBoard().getCube().getX() <= getBoard().getHeight() - 3) {
                Board tempBoard = getBoard().moveDown();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 1));
                }
            }
            if (getBoard().getCube().getY() >= 2) {
                Board tempBoard = getBoard().moveLeft();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 2));
                }
            }
            if (getBoard().getCube().getY() <= getBoard().getLength() - 3) {
                Board tempBoard = getBoard().moveRight();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 3));
                }
            }
        } else {
            if (getBoard().getCube().isHorizontal()) {
                if (getBoard().getCube().getX() >= 1) {
                    Board tempBoard = getBoard().moveUp();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 0));
                    }
                }
                if (getBoard().getCube().getY() <= getBoard().getLength() - 3) {
                    Board tempBoard = getBoard().moveRight();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 3));
                    }
                }
            } else {
                if (getBoard().getCube().getX() >= 2) {
                    Board tempBoard = getBoard().moveUp();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 0));
                    }
                }
                if (getBoard().getCube().getY() <= getBoard().getLength() - 2) {
                    Board tempBoard = getBoard().moveRight();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 3));
                    }
                }
            }
            if (getBoard().getCube().getX() <= getBoard().getHeight() - 2) {
                Board tempBoard = getBoard().moveDown();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 1));
                }
            }
            if (getBoard().getCube().getY() >= 1) {
                Board tempBoard = getBoard().moveLeft();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 2));
                }
            }

        }

        return states;
    }

    public ArrayList<State> makeReversedChild() {
        ArrayList<State> states = new ArrayList<>();
        if (getBoard().getCube().isStand()) {
            if (getBoard().getCube().getX() >= 2) {
                Board tempBoard = getBoard().moveUp();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 0));
                }
            }
            if (getBoard().getCube().getX() <= getBoard().getHeight() - 3) {
                Board tempBoard = getBoard().moveDown();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 1));
                }
            }
            if (getBoard().getCube().getY() >= 2) {
                Board tempBoard = getBoard().moveLeft();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 2));
                }
            }
            if (getBoard().getCube().getY() <= getBoard().getLength() - 3) {
                Board tempBoard = getBoard().moveRight();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 3));
                }
            }
        } else {
            if (getBoard().getCube().isHorizontal()) {
                if (getBoard().getCube().getX() >= 1) {
                    Board tempBoard = getBoard().moveUp();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 0));
                    }
                }
                if (getBoard().getCube().getY() <= getBoard().getLength() - 3) {
                    Board tempBoard = getBoard().moveRight();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 3));
                    }
                }
            } else {
                if (getBoard().getCube().getX() >= 2) {
                    Board tempBoard = getBoard().moveUp();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 0));
                    }
                }
                if (getBoard().getCube().getY() <= getBoard().getLength() - 2) {
                    Board tempBoard = getBoard().moveRight();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 3));
                    }
                }
            }
            if (getBoard().getCube().getX() <= getBoard().getHeight() - 2) {
                Board tempBoard = getBoard().moveDown();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 1));
                }
            }
            if (getBoard().getCube().getY() >= 1) {
                Board tempBoard = getBoard().moveLeft();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 2));
                }
            }

        }

        if (getBoard().getCube().isStand()) {
            if (getBoard().getCube().getX() >= 2) {
                Board tempBoard = getBoard().moveUpWithoutColoring();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 0));
                }
            }
            if (getBoard().getCube().getX() <= getBoard().getHeight() - 3) {
                Board tempBoard = getBoard().moveDownWithoutColoring();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 1));
                }
            }
            if (getBoard().getCube().getY() >= 2) {
                Board tempBoard = getBoard().moveLeftWithoutColoring();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 2));
                }
            }
            if (getBoard().getCube().getY() <= getBoard().getLength() - 3) {
                Board tempBoard = getBoard().moveRightWithoutColoring();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 3));
                }
            }
        } else {
            if (getBoard().getCube().isHorizontal()) {
                if (getBoard().getCube().getX() >= 1) {
                    Board tempBoard = getBoard().moveUpWithoutColoring();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 0));
                    }
                }
                if (getBoard().getCube().getY() <= getBoard().getLength() - 3) {
                    Board tempBoard = getBoard().moveRightWithoutColoring();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 3));
                    }
                }
            } else {
                if (getBoard().getCube().getX() >= 2) {
                    Board tempBoard = getBoard().moveUpWithoutColoring();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 0));
                    }
                }
                if (getBoard().getCube().getY() <= getBoard().getLength() - 2) {
                    Board tempBoard = getBoard().moveRightWithoutColoring();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 3));
                    }
                }
            }
            if (getBoard().getCube().getX() <= getBoard().getHeight() - 2) {
                Board tempBoard = getBoard().moveDownWithoutColoring();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 1));
                }
            }
            if (getBoard().getCube().getY() >= 1) {
                Board tempBoard = getBoard().moveLeftWithoutColoring();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 2));
                }
            }
            if (getBoard().getCube().isHorizontal()) {
                if (getBoard().getCube().getX() >= 1) {
                    Board tempBoard = getBoard().moveUpWithoutColoringFirstTile();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 0));
                    }
                }
                if (getBoard().getCube().getY() <= getBoard().getLength() - 3) {
                    Board tempBoard = getBoard().moveRightWithoutColoringFirstTile();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 3));
                    }
                }
            } else {
                if (getBoard().getCube().getX() >= 2) {
                    Board tempBoard = getBoard().moveUpWithoutColoringFirstTile();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 0));
                    }
                }
                if (getBoard().getCube().getY() <= getBoard().getLength() - 2) {
                    Board tempBoard = getBoard().moveRightWithoutColoringFirstTile();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 3));
                    }
                }
            }
            if (getBoard().getCube().getX() <= getBoard().getHeight() - 2) {
                Board tempBoard = getBoard().moveDownWithoutColoringFirstTile();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 1));
                }
            }
            if (getBoard().getCube().getY() >= 1) {
                Board tempBoard = getBoard().moveLeftWithoutColoringFirstTile();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 2));
                }
            }

            if (getBoard().getCube().isHorizontal()) {
                if (getBoard().getCube().getX() >= 1) {
                    Board tempBoard = getBoard().moveUpWithoutColoringSecondTile();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 0));
                    }
                }
                if (getBoard().getCube().getY() <= getBoard().getLength() - 3) {
                    Board tempBoard = getBoard().moveRightWithoutColoringSecondTile();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 3));
                    }
                }
            } else {
                if (getBoard().getCube().getX() >= 2) {
                    Board tempBoard = getBoard().moveUpWithoutColoringSecondTile();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 0));
                    }
                }
                if (getBoard().getCube().getY() <= getBoard().getLength() - 2) {
                    Board tempBoard = getBoard().moveRightWithoutColoringSecondTile();
                    if (tempBoard != null) {
                        states.add(new State(getDepth(), tempBoard, this, 3));
                    }
                }
            }
            if (getBoard().getCube().getX() <= getBoard().getHeight() - 2) {
                Board tempBoard = getBoard().moveDownWithoutColoringSecondTile();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 1));
                }
            }
            if (getBoard().getCube().getY() >= 1) {
                Board tempBoard = getBoard().moveLeftWithoutColoringSecondTile();
                if (tempBoard != null) {
                    states.add(new State(getDepth(), tempBoard, this, 2));
                }
            }

        }

        return states;
    }

    public boolean isFinal() {
        return getBoard().isFinal();
    }

    public void reversePrint() {
        Queue<Integer> actions = new LinkedList<>();
        State temp = this;
        while (temp.parent != null) {
            actions.add(temp.action);
            temp = temp.parent;
        }
        System.out.println(actions.size());
        while (!actions.isEmpty()) {
            switch (actions.poll()) {
                case 0:
                    System.out.println("down");
                    break;
                case 1:
                    System.out.println("up");
                    break;
                case 3:
                    System.out.println("left");
                    break;
                case 2:
                    System.out.println("right");
                    break;
            }
        }

    }

    public void print() {
        Stack<Integer> actions = new Stack<>();
        State temp = this;
        while (temp.parent != null) {
            actions.push(temp.action);
            temp = temp.parent;
        }
        System.out.println(actions.size());
        while (!actions.isEmpty()) {
            switch (actions.pop()) {
                case 0:
                    System.out.println("up");
                    break;
                case 1:
                    System.out.println("down");
                    break;
                case 3:
                    System.out.println("right");
                    break;
                case 2:
                    System.out.println("left");
                    break;
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        State state = (State) o;
        return getBoard().equals(state.getBoard());
    }

    @Override
    public int compareTo(State state) {
        if (this.equals(state)) {
            return 0;
        }
        return 1;
    }

    /**
     * @return the depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @return the totalCost
     */
    public double getTotalCost() {
        return totalCost;
    }
    
    public void changeTotalCost(double totalCost){
        this.totalCost = totalCost;
    }

    private double getHeuristic() {
        double zeroCounter = 0;
        for (int i = 0; i < this.board.getHeight(); i++) {
            for (int j = 0; j < this.board.getLength(); j++) {
                if (board.getMap()[i][j] == 0) {
                    zeroCounter++;
                }
            }
        }
        return zeroCounter/2;
    }

}
