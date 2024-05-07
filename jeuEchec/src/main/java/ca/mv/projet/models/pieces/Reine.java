package main.java.ca.mv.projet.models.pieces;

import main.java.ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public class Reine extends Piece {

    public Reine(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        // TODO: remplacer par le code approprié
        System.out.println("peutBouger reine");
        return true;
    }
}
