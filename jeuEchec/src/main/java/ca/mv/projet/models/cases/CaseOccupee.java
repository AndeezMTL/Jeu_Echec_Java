package main.java.ca.mv.projet.models.cases;

import ca.mv.projet.models.cases.Position;
import main.java.ca.mv.projet.models.Echiquier;
import main.java.ca.mv.projet.models.pieces.Piece;

public class CaseOccupee extends Case {

    private Piece piece;

    public CaseOccupee(Position position, Piece piece) {
        super(position, piece);
        // TODO: remplacer par le code approprié
    }

    public boolean peutBouger(Position position, Position posDestination, Echiquier echiquier) {
        if (!posDestination.estValide()) {
            return false;
        }
        
        return false;
    }
}
