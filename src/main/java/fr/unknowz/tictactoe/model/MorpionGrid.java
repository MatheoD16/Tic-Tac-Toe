package fr.unknowz.tictactoe.model;

public class MorpionGrid {
    public static final int SIZE = 3;
    private MorpionCase[][] grid;

    public MorpionGrid() {
        grid = new MorpionCase[SIZE][SIZE];
        for (int i = 0; i< SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = new MorpionCase(i,j);
            }
        }
    }

    public MorpionCase getCase(int x, int y) {
        return grid[x][y];
    }

    public void touched(int x, int y, ColorPlayer color) {
        grid[x][y].setColor(color);
        grid[x][y].setUsed(true);
    }

    public boolean validationRow(ColorPlayer color) {
        for (int i = 0; i< SIZE; i++) {
            if ((grid[i][0].getColor() == color) && (grid[i][1].getColor() == color) && (grid[i][2].getColor() == color)) {
                return true;
            }
        }
        return false;
    }

    public boolean validationColumn(ColorPlayer color) {
        for (int j = 0; j< SIZE; j++) {
            if ((grid[0][j].getColor() == color) && (grid[1][j].getColor() == color) && (grid[2][j].getColor() == color)) {
                return true;
            }
        }
        return false;
    }

    public boolean validationDiagonal(ColorPlayer color) {
        if ((grid[0][0].getColor() == color) && (grid[1][1].getColor() == color) && (grid[2][2].getColor() == color)) {
            return true;
        }
        if ((grid[0][2].getColor() == color) && (grid[1][1].getColor() == color) && (grid[2][0].getColor() == color)) {
            return true;
        }
        return false;
    }

    public boolean validation(ColorPlayer color) {
        return (validationRow(color) || validationColumn(color) || validationDiagonal(color));
    }


    public void clear() {
        grid = new MorpionCase[SIZE][SIZE];
        for (int i = 0; i< SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = new MorpionCase(i,j);
            }
        }
    }

    @Override
    public String toString() {
        String str = "MorpionGrid : ";
        for (int i = 0; i< SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                str = str + grid[i][j];
            }

        }
        return str;
    }
}
