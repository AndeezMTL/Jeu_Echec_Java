package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;


public class Reine extends Piece {
    private final Tour verifMouvTour = new Tour(estBlanc);
    private final Fou verifMouvFou = new Fou(estBlanc);

    public Reine(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        // Vérifie si le mouvement est valide pour une tour ou un fou
        return verifMouvTour.peutBouger(posCourante, posDestination, echiquier) || verifMouvFou.peutBouger(posCourante, posDestination, echiquier);
    }
}

