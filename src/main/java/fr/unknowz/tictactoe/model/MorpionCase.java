package fr.unknowz.tictactoe.model;

public class MorpionCase {

    private int x;
    private int y;
    private ColorPlayer color;
    private boolean used;

    public MorpionCase(int x, int y) {
        this.x = x;
        this.y = y;
        color = null;
        used = false;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public ColorPlayer getColor() {
        return color;
    }
    public void setColor(ColorPlayer color) {
        this.color = color;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "MorpionCase [x=" + x + ", y=" + y + ", color=" + color + ", used=" + used + "]";
    }

}
