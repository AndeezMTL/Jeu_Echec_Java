package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;


public class Reine extends Piece {

    public Reine(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        // Vérifie si le mouvement est valide pour une tour ou un fou
        return bougerSurDiagonal(posCourante, posDestination, echiquier) || bougerSurOrthogonal(posCourante, posDestination, echiquier);
    }
}

