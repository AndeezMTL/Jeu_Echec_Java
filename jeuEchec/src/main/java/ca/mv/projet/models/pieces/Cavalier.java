package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public class Cavalier extends Piece {

    public Cavalier(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        // TODO: remplacer par le code approprié

        int mouvementY = posDestination.getY() - posCourante.getY();
        int mouvementX = posDestination.getX() - posCourante.getX();


        if (
                (mouvementX == 2 && mouvementY == 1) || (mouvementX == -2 && mouvementY == 1) ||
                (mouvementX == 2 && mouvementY == -1) || (mouvementX == -2 && mouvementY == -1) ||
                (mouvementX == 1 && mouvementY == 2) || (mouvementX == -1 && mouvementY == 2) ||
                (mouvementX == 1 && mouvementY == -2) || (mouvementX == -1 && mouvementY == -2)
            )

                {
                    if (echiquier.get)
                }




            System.out.println("peutBouger cavalier");
        return true;
    }
}
