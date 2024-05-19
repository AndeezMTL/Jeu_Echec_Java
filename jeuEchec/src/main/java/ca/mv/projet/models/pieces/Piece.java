package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public abstract class Piece {
    protected final boolean estBlanc;
    protected boolean estCapturee;
//commentaire
    protected String image;

    public Piece(boolean estBlanc) {
        this.estCapturee = false;
        this.estBlanc = estBlanc;
        this.image = this.getClass().getSimpleName() + (estBlanc ? "Blanc" : "") + ".png";
    }

    public void die() {
        this.estCapturee = true;
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

    /* Code fourni dans github*/
    protected boolean bougerSurDiagonal(Position posCourante, Position posDestination, Echiquier echiquier) {
        boolean invalid = false;

        if (this.estSurDiagonal(posCourante, posDestination)) {
            Position direction = posDestination.substract(posCourante).direction();
            Position pos = posCourante.add(direction);

            while (!pos.equals(posDestination)) {
                if (echiquier.estOccupe(pos)) {
                    return invalid;
                }
                pos = pos.add(direction);
            }
            return this.peutCapturer(echiquier.getPieceAtPosition(posDestination));
        }
        return false;
    }



    public boolean estMemeCouleur(Piece piece) {
        return estBlanc == piece.estBlanc;
    }

    public boolean peutCapturer(Piece pieceDestination) {
        if(pieceDestination != null) {
            return !estMemeCouleur(pieceDestination);
        }
        return true;
    }

    public boolean bougerSurOrthogonal(Position posCourante, Position posDestination, Echiquier echiquier) {
        if (posDestination.getX() == posCourante.getX() || posDestination.getY() == posCourante.getY()) {
            Position direction = posDestination.substract(posCourante).direction();
            Position pos = posCourante.add(direction);
            boolean invalid = false;

            while (!pos.equals(posDestination)) {
                if (echiquier.estOccupe(pos)) {
                    return invalid;
                }
                pos = pos.add(direction);
            }
            return this.peutCapturer(echiquier.getPieceAtPosition(posDestination));
        }
        return false;
    }

    public boolean estSurDiagonal(Position posCourante, Position posDestination) {
        Position mouvement = posDestination.substract(posCourante).abs();
        return mouvement.getX() == mouvement.getY();
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

