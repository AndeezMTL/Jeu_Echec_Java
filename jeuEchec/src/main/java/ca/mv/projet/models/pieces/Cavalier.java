package main.java.ca.mv.projet.models.pieces;

import main.java.ca.mv.projet.models.Echiquier;
import main.java.ca.mv.projet.models.cases.Position;

public class Cavalier extends Piece {

    public Cavalier(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        int mouvementY = posDestination.getY() - posCourante.getY();
        int mouvementX = posDestination.getX() - posCourante.getX();

        if ((mouvementX == Math.abs(2) && mouvementY == Math.abs(1)) || (mouvementY == Math.abs(2) && mouvementX == Math.abs(1))) {
            Piece caseOccupeePiece = echiquier.getPieceAtPosition(new Position(posDestination.getX(), posDestination.getY()));
            if (caseOccupeePiece != null) {
                if (caseOccupeePiece.isEstBlanc() == this.isEstBlanc()) {
                    //il y a une pièce de même couleur sur la case, on ne peut pas bouger
                    return false;
                }
                System.out.println("peutBouger cavalier");
                return true;//la pièce peut bouger, la case est occupée par une pièce ennemioe (donc on va la capturer)
            }
            System.out.println("peutBouger cavalier");
            return true;
            }
        return false;
    }
}
