package ca.mv.projet.models.cases;

import ca.mv.projet.models.cases.Position;
import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.pieces.Piece;
import ca.mv.projet.models.cases.Case;

public class CaseOccupee extends Case {

    private Piece piece;

    public CaseOccupee(Position position, Piece piece) {
        super(position, piece);
        // TODO: remplacer par le code approprié
    }

    public boolean peutBouger(Position position, Position posDestination, Echiquier echiquier) {
        Case caseCourante = echiquier.getCaseParPosition(position);
        Case caseDestination = echiquier.getCaseParPosition(posDestination);
        Piece piece = caseCourante.getPiece();
        Piece pieceDestination = caseDestination.getPiece();

        if (!posDestination.isValid()) {
            return false;
        }

        if (caseDestination.getPiece() != null && pieceDestination.isEstBlanc() == piece.isEstBlanc()) {
            return false;
        }

        if (!piece.peutBouger(position, posDestination, echiquier)) {
            return false;
        }

        return true;
    }
}
