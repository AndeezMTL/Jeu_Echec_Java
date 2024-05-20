package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public class Pion extends Piece {
    private final Position positionInitiale;

    public Pion(boolean estBlanche, Position positionInitiale) {
        super(estBlanche);
        this.positionInitiale = positionInitiale;
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        int direction = estBlanc ? -1 : 1; // La couleur détermine la direction du mouvement
        if (
            posDestination.equals(posCourante.add(0, direction))
        ) {
            return !echiquier.estOccupe(posDestination);
        } else if (
            posDestination.equals(posCourante.add(1, direction)) ||
            posDestination.equals(posCourante.add(-1, direction))
        ) {
            return echiquier.estOccupe(posDestination) && this.peutCapturer(echiquier.getPieceAtPosition(posDestination));
        } else {
            return false;
        }
    }

    private static boolean estDeplacLegal(int pasX, int pasY, boolean estPremierMouve,
                                         boolean estCaseVides, boolean estPieceAdversaire) {
        boolean estDeplacLegalSurY = false;
        boolean estDeplacLegalSurX = false;

        if(estCaseVides) {
            estDeplacLegalSurY = pasY == 0;
            // Premier mouvement
            if (estPremierMouve) {
                estDeplacLegalSurX = pasX == 1 || pasX == 2;
                // Mouvement simple
            } else {
                estDeplacLegalSurX = pasX == 1;
            }
            // Capture en diagonale
        } else {
            if(estPieceAdversaire) {
                estDeplacLegalSurX = pasX == 1;
                estDeplacLegalSurY = Math.abs(pasY) == 1;
            }
        }

        return estDeplacLegalSurX && estDeplacLegalSurY;
    }

    public Piece promouvoir(String type) {
        // Retourne une nouvelle pièce (Reine, par exemple) en cas de promotion
        return new Reine(this.estBlanc);
    }
}
