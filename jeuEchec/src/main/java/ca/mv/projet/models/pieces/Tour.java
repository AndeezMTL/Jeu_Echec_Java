package main.java.ca.mv.projet.models.pieces;

import main.java.ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public class Tour extends Piece {
    public Tour(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        System.out.println("peutBouger tout");
        return true;
    }
}
