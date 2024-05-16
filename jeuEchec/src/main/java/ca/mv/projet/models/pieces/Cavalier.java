package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public class Cavalier extends Piece {

    public Cavalier(boolean estBlanche) {
        super(estBlanche);
    }

    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        Position mouvement = posDestination.substract(posCourante).abs();

        if (mouvement.equals(2, 1) || mouvement.equals(1, 2)) {
            Piece caseOccupeePiece = echiquier.getPieceAtPosition(posDestination);
            if (caseOccupeePiece != null) {
                return this.peutCapturer(caseOccupeePiece);
            }
            System.out.println("peut Bouger cavalier");
            return true;
            }
        return false;
    }
}
