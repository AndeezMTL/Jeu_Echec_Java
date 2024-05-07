package main.java.ca.mv.projet.models.pieces;

import main.java.ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public abstract class Piece {
    protected final boolean estBlanc;
    protected boolean estCapturee = false;
//commentaire
    protected String image;

    public Piece(boolean estBlanc) {
        this.estCapturee = false;
        this.estBlanc = estBlanc;
        this.image = this.getClass().getSimpleName() + "_" + (estBlanc ? "blanc" : "noir") + ".gif";
    }

    public abstract boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier);

    public boolean isEstBlanc() {
        return estBlanc;
    }

    public boolean isEstCapturee() {
        return estCapturee;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "estBlanc=" + estBlanc +
                ", estCapturee=" + estCapturee +
                ", image='" + image + '\'' +
                '}';
    }
}

