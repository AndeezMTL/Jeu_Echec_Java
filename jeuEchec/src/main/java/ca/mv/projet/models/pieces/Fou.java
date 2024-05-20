package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public class Fou extends Piece {

    public Fou(boolean estBlanche) {
        super(estBlanche);
    }

    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        return bougerSurDiagonal(posCourante, posDestination, echiquier);
    }

}
