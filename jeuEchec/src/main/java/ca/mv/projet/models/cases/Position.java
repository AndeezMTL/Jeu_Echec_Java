package ca.mv.projet.models.cases;


import ca.mv.projet.Utilities;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {     //constructeur de position
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
        return x < 8 && x >= 0 && y < 8 && y >= 0; //vérifie si la position est dans l'échequier
    }

    public int convertirEnIndex(){
        return x + y * Utilities.NB_CASES_COTE;
    } //donne un index unique à chaque positions

    public boolean equals(Position pos) {
        return x == pos.x && y == pos.y;
    } //compare les position en vérifiant leurs x et y

    public boolean equals(int _x, int _y) {
        return _x == x && _y == y;
    } //compare les x et y d'une position a ceux d'une autre

    public Position add(Position pos) {
        return new Position(x + pos.x, y + pos.y);
    } //additionne 2 positions

    public Position add(int x, int y) {
        return new Position(x + this.x, y + this.y);
    } //additionne une valeur x et une valeur y à celles de la position

    public Position substract(Position pos) {
        return new Position(x - pos.x, y - pos.y);
    }   //soustrait 2 positions

    public Position substract(int x, int y) {
        return new Position(this.x - x, this.y - y);
    } //soustrait une valeur x et une valeur y à celles de la position

    public Position abs() {
        return new Position(Math.abs(x), Math.abs(y));
    } //retourne une position qui a la valeur absolue du x et du y de la position originale (ex: Position pos = new Position (-2, -3), alors pos.abs() == (2, 3)

    public Position direction() {
        int X, Y;
        if (x == 0) {X = 0;}else{X = x/Math.abs(x);}
        if (y == 0) {Y = 0;}else{Y = y/Math.abs(y);}
        return new Position(X, Y);
    } //détermine la direction de mouvement en retournant -1 ou 1



    @Override
    public String toString() {
        return '(' + x + ", " + y +')';
    } //affiche les coordonées x & y de la position en tant que string
}
