package src.models;

import java.util.Arrays;
import java.util.Objects;

public class Board implements Cloneable {


    private int[][] map;
    //-1 -> hole
    //0 -> empty
    //1 -> colored
    //2 -> cube

    private int length;
    private int height;
    private Cube cube;

    private Board(Board board) {
        this.map = new int[board.height][board.length];
        this.cube = new Cube(board.cube);
        for (int i = 0; i < board.height; i++)
            if (board.length >= 0) System.arraycopy(board.map[i], 0, this.map[i], 0, board.length);
        this.length = board.length;
        this.height = board.height;
    }

    public Board(int length, int height, String map, Cube cube) {
        this.map = new int[height][length];
        this.cube = cube;
        int count = 0;
        for (int i = 0; i < height; i++)
            for (int j = 0; j < length; j++) {
                if (map.charAt(count) == '.') {
                    this.map[i][j] = 0;
                }
                if (map.charAt(count) == '*') {
                    this.map[i][j] = -1;
                }
                count++;
            }
        this.map[cube.getX()][cube.getY()] = 2;
        this.length = length;
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public Cube getCube() {
        return cube;
    }

    private void removeCubeFromMapWithoutColoring() {
        if (cube.isStand()) {
            map[cube.getX()][cube.getY()] = 0;
        } else {
            if (cube.isHorizontal()) {
                map[cube.getX()][cube.getY()] = 0;
                map[cube.getX()][cube.getY() + 1] = 0;
            } else {
                map[cube.getX() - 1][cube.getY()] = 0;
                map[cube.getX()][cube.getY()] = 0;
            }
        }
    }
    
    private void removeCubeFromMapWithoutColoringFirstTile() {
        if (cube.isStand()) {
            map[cube.getX()][cube.getY()] = 0;
        } else {
            if (cube.isHorizontal()) {
                map[cube.getX()][cube.getY()] = 1;
                map[cube.getX()][cube.getY() + 1] = 0;
            } else {
                map[cube.getX() - 1][cube.getY()] = 1;
                map[cube.getX()][cube.getY()] = 0;
            }
        }
    }
    
    private void removeCubeFromMapWithoutColoringSecondTile() {
        if (cube.isStand()) {
            map[cube.getX()][cube.getY()] = 0;
        } else {
            if (cube.isHorizontal()) {
                map[cube.getX()][cube.getY()] = 0;
                map[cube.getX()][cube.getY() + 1] = 1;
            } else {
                map[cube.getX() - 1][cube.getY()] = 0;
                map[cube.getX()][cube.getY()] = 1;
            }
        }
    }
    
    private void removeCubeFromMap() {
        if (cube.isStand()) {
            map[cube.getX()][cube.getY()] = 1;
        } else {
            if (cube.isHorizontal()) {
                map[cube.getX()][cube.getY()] = 1;
                map[cube.getX()][cube.getY() + 1] = 1;
            } else {
                map[cube.getX() - 1][cube.getY()] = 1;
                map[cube.getX()][cube.getY()] = 1;
            }
        }
    }

    private boolean addCubeToMap() {
        if (cube.isStand()) {
            if (getMap()[cube.getX()][cube.getY()] == -1)
                return false;
            map[cube.getX()][cube.getY()] = 2;

        } else {
            if (cube.isHorizontal()) {
                if (getMap()[cube.getX()][cube.getY()] == -1 || getMap()[cube.getX()][cube.getY() + 1] == -1)
                    return false;
                map[cube.getX()][cube.getY()] = 2;
                map[cube.getX()][cube.getY() + 1] = 2;
            } else {
                if (getMap()[cube.getX()][cube.getY()] == -1 || getMap()[cube.getX() - 1][cube.getY()] == -1)
                    return false;
                map[cube.getX()][cube.getY()] = 2;
                map[cube.getX() - 1][cube.getY()] = 2;
            }
        }
        return true;
    }

    Board moveRight() {
        Board board = new Board(this);
        board.removeCubeFromMap();
        board.cube.moveRight();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }

    Board moveLeft() {
        Board board = new Board(this);
        board.removeCubeFromMap();
        board.cube.moveLeft();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }

    Board moveDown() {
        Board board = new Board(this);
        board.removeCubeFromMap();
        board.cube.moveDown();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }

    Board moveUp() {
        Board board = new Board(this);
        board.removeCubeFromMap();
        board.cube.moveUp();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }

    Board moveRightWithoutColoring() {
        Board board = new Board(this);
        board.removeCubeFromMapWithoutColoring();
        board.cube.moveRight();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }

    Board moveLeftWithoutColoring() {
        Board board = new Board(this);
        board.removeCubeFromMapWithoutColoring();
        board.cube.moveLeft();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }

    Board moveDownWithoutColoring() {
        Board board = new Board(this);
        board.removeCubeFromMapWithoutColoring();
        board.cube.moveDown();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }

    Board moveUpWithoutColoring() {
        Board board = new Board(this);
        board.removeCubeFromMapWithoutColoring();
        board.cube.moveUp();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }
    
    Board moveRightWithoutColoringFirstTile() {
        Board board = new Board(this);
        board.removeCubeFromMapWithoutColoringFirstTile();
        board.cube.moveRight();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }

    Board moveLeftWithoutColoringFirstTile() {
        Board board = new Board(this);
        board.removeCubeFromMapWithoutColoringFirstTile();
        board.cube.moveLeft();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }

    Board moveDownWithoutColoringFirstTile() {
        Board board = new Board(this);
        board.removeCubeFromMapWithoutColoringFirstTile();
        board.cube.moveDown();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }

    Board moveUpWithoutColoringFirstTile() {
        Board board = new Board(this);
        board.removeCubeFromMapWithoutColoringFirstTile();
        board.cube.moveUp();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }
    
    Board moveRightWithoutColoringSecondTile() {
        Board board = new Board(this);
        board.removeCubeFromMapWithoutColoringSecondTile();
        board.cube.moveRight();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }

    Board moveLeftWithoutColoringSecondTile() {
        Board board = new Board(this);
        board.removeCubeFromMapWithoutColoringSecondTile();
        board.cube.moveLeft();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }

    Board moveDownWithoutColoringSecondTile() {
        Board board = new Board(this);
        board.removeCubeFromMapWithoutColoringSecondTile();
        board.cube.moveDown();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }

    Board moveUpWithoutColoringSecondTile() {
        Board board = new Board(this);
        board.removeCubeFromMapWithoutColoringSecondTile();
        board.cube.moveUp();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }
    
    public boolean isFinal() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (getMap()[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        boolean a = Arrays.deepEquals(getMap(), board.getMap());
        boolean b = Objects.equals(cube, board.cube);
        return a && b;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(cube);
        result = 31 * result + Arrays.hashCode(getMap());
        return result;
    }

    /**
     * @return the map
     */
    public int[][] getMap() {
        return map;
    }
}
