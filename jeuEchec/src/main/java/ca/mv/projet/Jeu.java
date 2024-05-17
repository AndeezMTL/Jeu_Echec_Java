package ca.mv.projet;

import ca.mv.projet.models.Grille;
import ca.mv.projet.models.Joueur;
import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;
import ca.mv.projet.models.pieces.Piece;
import ca.mv.projet.models.pieces.Pion;
import ca.mv.projet.models.pieces.Roi;

public class Jeu {
    // TODO: ajouter le code manquant
    private Echiquier echiquier;
    private Joueur j1;
    private Joueur j2;
    private Grille grille;
    private int tourDeJeux;


    public Echiquier getEchiquier() {
        return echiquier;
    }

    public Joueur getJ1() {
        return j1;
    }

    public Joueur getJ2() {
        return j2;
    }

    public Grille getGrille() {
        return grille;
    }

    public Jeu() {
        // TODO: ajouter le code et les paramètres appropriés

        this.echiquier = new Echiquier();
        this.j1 = new Joueur(Utilities.j1_name, true);
        this.j2 = new Joueur(Utilities.j2_name, false);
        this.grille = new Grille(this.echiquier);
    }

    private boolean estTourDesBlanc() {
        return (this.tourDeJeux % 2) == 0;
    }

    public void mancheJouee(Position pFrom, Position pTo) {
        if (estTourDesBlanc() == echiquier.getPieceAtPosition(pFrom).isEstBlanc()) {
            ResultatManche manche = executeMove(pFrom, pTo);
            switch (manche){
                case INVALIDE -> {
                    System.out.println("Le mouvement est invalide");

                }
                case DEPLACEMENT -> {
                    tourDeJeux++;
                }
                case CAPTURE -> {
                    tourDeJeux++;
                }
                case ECHEC -> {
                    System.out.println("Échec et math");

                }
//                case null, default -> {
//                    throw new Exception("sorcellerie");
//                }
            }

        }
    }

    public ResultatManche executeMove(Position pFrom, Position pTo) {
        if (echiquier.estOccupe(pFrom)) {
            if (echiquier.estValidMouve(pFrom, pTo)) {
                Piece pieceBouffe = echiquier.getPieceAtPosition(pTo);
                if (pieceBouffe != null) {
                    pieceBouffe.die();
                    if (pieceBouffe.getClass() == Roi.class) {
                        // win
                        return ResultatManche.ECHEC;
                    }
                    echiquier.setCaseParPosition(pFrom, pTo);
                    return ResultatManche.CAPTURE;
                }
                echiquier.setCaseParPosition(pFrom, pTo);
                return ResultatManche.DEPLACEMENT;
            }
        }
        return ResultatManche.INVALIDE;
    }
}
