package ca.mv.projet.models.cases;


import ca.mv.projet.Utilities;

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

    public boolean isValid() {
        return x < 8 && x >= 0 && y < 8 && y >= 0;
    }

    public int convertirEnIndex(){
        return x + y * Utilities.NB_CASES_COTE;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Position position = (Position) o;
//        return x == position.x && y == position.y;
//    }

    public boolean equals(Position pos) {
        return x == pos.x && y == pos.y;
    }

    public boolean equals(int _x, int _y) {
        return _x == x && _y == y;
    }

    public Position add(Position pos) {
        return new Position(x + pos.x, y + pos.y);
    }

    public Position add(int x, int y) {
        return new Position(x + this.x, y + this.y);
    }

    public Position substract(Position pos) {
        return new Position(x - pos.x, y - pos.y);
    }

    public Position substract(int x, int y) {
        return new Position(this.x - x, this.y - y);
    }

    public Position abs() {
        return new Position(Math.abs(x), Math.abs(y));
    }

    public Position direction() {
        int X, Y;
        if (x == 0) {X = 0;}else{X = x/Math.abs(x);}
        if (y == 0) {Y = 0;}else{Y = y/Math.abs(y);}
        return new Position(X, Y);
    }

    @Override
    public String toString() {
        return '(' + x + ", " + y +')';
    }
}
