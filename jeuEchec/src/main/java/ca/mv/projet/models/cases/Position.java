package main.java.ca.mv.projet.models.cases;


import main.java.ca.mv.projet.Utilities;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean estValide() {
        if (x < 8 && x >= 0 && y < 8 && y >= 0) {
            return true;
        }
        return false;
    }

    public int convertirEnIndex(){
        return x + y * Utilities.NB_CASES_COTE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
