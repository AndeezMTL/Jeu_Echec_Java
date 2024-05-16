package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public class Roi extends Piece {

    public Roi(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        Position mouvement = posCourante.substract(posDestination);
        return mouvement.equals(mouvement.direction()) && echiquier.getPieceAtPosition(posDestination).isEstBlanc() != this.isEstBlanc();
    }
}


