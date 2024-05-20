package ca.mv.projet.models.cases;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.pieces.Piece;


public class CaseOccupee extends Case {

    private Piece piece;    //la piece de la case

    public CaseOccupee(Position position, Piece piece) {
        super(position, piece);
    }

    public boolean peutBouger(Position position, Position posDestination, Echiquier echiquier) {    //regarde est ce qu'un mouvement est legal
        Case caseCourante = echiquier.getCaseParPosition(position);
        Case caseDestination = echiquier.getCaseParPosition(posDestination);
        Piece piece = caseCourante.getPiece();
        Piece pieceDestination = caseDestination.getPiece();

        if (!posDestination.isValid()) {
            return false;   //return false si la case choisie est dans une position à l'extérieur de l'échequier
        }

        if (caseDestination.getPiece() != null && pieceDestination.isEstBlanc() == piece.isEstBlanc()) {
            return false;   //si la case destination à une pièce de même couleur que celle qu'on veut bouger, return false
        }

        if (!piece.peutBouger(position, posDestination, echiquier)) {
            return false;   //si la piece peut pas bouger, return false
        }

        return true;
    }
}
