package main.java.ca.mv.projet.models.pieces;

import main.java.ca.mv.projet.models.Echiquier;
import main.java.ca.mv.projet.models.cases.Position;

public class Fou extends Piece {

    public Fou(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        int mouvementY = posDestination.getY() - posCourante.getY();
        int mouvementX = posDestination.getX() - posCourante.getX();

        // Vérification si le mouvement est en diagonale
        if (estSurDiagonale(posCourante, posDestination)) {
            // Vérification s'il n'y a pas d'obstacles sur la diagonale
            int stepX = mouvementX > 0 ? 1 : -1;
            int stepY = mouvementY > 0 ? 1 : -1;
            int x = posCourante.getX() + stepX;
            int y = posCourante.getY() + stepY;

            while (x != posDestination.getX() || y != posDestination.getY()) {
                Piece caseOccupeePiece = echiquier.getPieceAtPosition(new Position(x, y));
                if (caseOccupeePiece != null) {
                    if (caseOccupeePiece.isEstBlanc() == this.isEstBlanc()) {
                        //il y a une pièce de même couleur sur la case, on ne peut pas bouger
                        return false;
                    }
                    return true; //la pièce peut bouger, la case est occupée par une pièce ennemioe (donc on va la capturer)
                }
                x += stepX;
                y += stepY;
            }
            return true;
        }
        return false;
    }

    public boolean estSurDiagonale(Position posCourante, Position posDestination) {
        int diffSurX = posDestination.getX() - posCourante.getX();
        int diffSurY = posDestination.getY() - posCourante.getY();

        return Math.abs(diffSurX) == Math.abs(diffSurY);
    }
}
