package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public class Roi extends Piece {

    public Roi(boolean estBlanc) {
        super(estBlanc); //crée un roi
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        //si le déplacement est de 1 case dans n'importe qu'elle direction
        if ((posDestination.getX() == posCourante.getX() + 1 || posDestination.getX() == posCourante.getX() - 1 || posDestination.getY() == posCourante.getY() + 1 || posDestination.getY() == posCourante.getY() - 1) || (this.estSurDiagonal(posCourante, posDestination)) ) {
            Position direction = posDestination.substract(posCourante).direction(); //même fonctionnement que les mouvements ortogonaux et diagonaux
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


