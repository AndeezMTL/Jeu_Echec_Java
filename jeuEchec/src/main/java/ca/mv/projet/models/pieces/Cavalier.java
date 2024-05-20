package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public class Cavalier extends Piece {

    public Cavalier(boolean estBlanche) {
        super(estBlanche);
    }

    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        Position mouvement = posDestination.substract(posCourante).abs(); //valeurs x et y entre la position de départ et la destination

        if (mouvement.equals(2, 1) || mouvement.equals(1, 2)) { //vérif si le déplacement équivaut au "L" du cavalier
            Piece caseOccupeePiece = echiquier.getPieceAtPosition(posDestination);
            if (caseOccupeePiece != null) {
                return this.peutCapturer(caseOccupeePiece);
            } //vérifie si le cavalier peut capturer la pièce a sa destination
            return true; //return true s'il n'y a pas de pièce à sa destination
            }
        return false; //false si le mouvement n'est pas en "L"
    }
}
