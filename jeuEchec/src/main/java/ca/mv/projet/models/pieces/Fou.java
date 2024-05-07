package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public class Fou extends Piece {

    public Fou(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        // TODO: remplacer par le code approprié
        int mouvementY = posDestination.getY() - posCourante.getY();
        int mouvementX = posDestination.getX() - posCourante.getX();


        if (
                (mouvementX == 2 && mouvementY == 2) || (mouvementX == -2 && mouvementY == -2) ||
                        (mouvementX == 2 && mouvementY == -2) || (mouvementX == -2 && mouvementY == 2) ||
                        (mouvementX == -1 && mouvementY == 1) || (mouvementX == 1 && mouvementY == 1) ||
                        (mouvementX == -2 && mouvementY == 2) || (mouvementX == -2 && mouvementY == 2)
        )

        {
            if (echiquier.get);
        }
        System.out.println("peutBouger fou");
        return true;
    }

    public boolean estSurDiagonal(Position posCourante, Position posDestination){
        // TODO : à tester
        int diffSurX = posDestination.getX() - posCourante.getX();
        int diffSurY = posDestination.getY() - posCourante.getY();

        return Math.abs(diffSurX) == Math.abs(diffSurY);
    }
}
