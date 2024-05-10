package main.java.ca.mv.projet.models.pieces;

import main.java.ca.mv.projet.models.Echiquier;
import main.java.ca.mv.projet.models.cases.Position;

public class Roi extends Piece {
    public Roi(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        int diffX = Math.abs(posDestination.getX() - posCourante.getX());
        int diffY = Math.abs(posDestination.getY() - posCourante.getY());

        // Vérifie si le mouvement est valide pour un roi (une seule case dans n'importe quelle direction)
        return (diffX <= 1 && diffY <= 1);
    }
}


