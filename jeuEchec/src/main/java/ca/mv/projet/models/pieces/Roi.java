package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public class Roi extends Piece {

    public Roi(boolean estBlanc) {
        super(estBlanc);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        if ((posDestination.getX() == posCourante.getX() + 1 || posDestination.getX() == posCourante.getX() - 1 || posDestination.getY() == posCourante.getY() + 1 || posDestination.getY() == posCourante.getY() - 1) || (this.estSurDiagonal(posCourante, posDestination)) ) {
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
}


