package main.java.ca.mv.projet.models.pieces;

import main.java.ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public class Reine extends Piece {

    public Reine(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        // Vérifie si le mouvement est valide pour une tour ou un fou
        Tour tour = new Tour(estBlanche);
        Fou fou = new Fou(estBlanche);
        return tour.peutBouger(posCourante, posDestination, echiquier) || fou.peutBouger(posCourante, posDestination, echiquier);
    }
}

