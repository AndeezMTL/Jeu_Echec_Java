package ca.mv.projet.models.cases;

import main.java.ca.mv.projet.models.pieces.Piece;
import ca.mv.projet.models.cases.Position;

public abstract class Case {
    private final Position posCourante;
    private Piece piece;
    private boolean estCaseBlanche;

    public Case(Position posCourante) {
        this.posCourante = posCourante;
        setEstCaseBlanche();
    }

    public Case(Position position, Piece piece) {
        this(position);
        this.piece = piece;
    }

    private void setEstCaseBlanche() {
        this.estCaseBlanche = (posCourante.getX() + posCourante.getY()) % 2 == 0;
    }

    public boolean isEstCaseBlanche(){
        return estCaseBlanche;
    }

    public Position getPosition() {
        return posCourante;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        return "Case{" +
                "position=" + posCourante +
                ", piece=" + piece +
                ", estCaseBlanche=" + estCaseBlanche +
                '}';
    }
}
