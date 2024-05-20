package ca.mv.projet;

import ca.mv.projet.models.Grille;
import ca.mv.projet.models.Joueur;
import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;
import ca.mv.projet.models.pieces.Piece;
import ca.mv.projet.models.pieces.Roi;

public class Jeu {
    private ResultatManche manche = ResultatManche.INVALIDE;
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
        this.echiquier = new Echiquier();
        this.j1 = new Joueur(Utilities.j1_name, true);
        this.j2 = new Joueur(Utilities.j2_name, false);
        this.grille = new Grille(this.echiquier);
        this.tourDeJeux = 0;
    }

    public boolean estTourDesBlanc() {
        return (this.tourDeJeux % 2) == 0; //les tours pairs sont aux blancs
    }

    public void mancheJouee(Position pFrom, Position pTo) {
        Piece pieceFrom = echiquier.getPieceAtPosition(pFrom);

        if (pieceFrom == null) {
            return; //si aucune pièce sélectionnée, execute aucun mouv
        }
        if (estTourDesBlanc() != pieceFrom.isEstBlanc()) {
            System.out.println("Pas le tour des " + (pieceFrom.isEstBlanc() ? "blancs" : "noirs")); //check si le tour = la couleur de la pièce clickée
            return;
        }

        ResultatManche manche = executeMove(pFrom, pTo);

        switch (manche) {
            case INVALIDE:
                System.out.println("Move invalide");
                break;
            case DEPLACEMENT:
            case CAPTURE:
                tourDeJeux++;
                grille.creerGrille(); //update la grile
                break;
            case ECHEC:
                System.out.println("Le roi " + (pieceFrom.isEstBlanc() ? "noir" : "blanc") + " à été capturé");
                break;
        }
    }

    public ResultatManche executeMove(Position pFrom, Position pTo) {
        Piece pieceDestination = echiquier.getPieceAtPosition(pTo);

        if (echiquier.estOccupe(pFrom)) { //si la position de départ à une pièce
            if (echiquier.estValidMouve(pFrom, pTo)) { // si le mouvement est valide
                if (pieceDestination != null) { //s'il y a une pièce dans la destination
                    pieceDestination.die(); //capture la pièce
                    if (pieceDestination.isEstBlanc() && pieceDestination.isEstCapturee()) {//vérifie si la pièce caturée est blanche ou noire, l'ajoute a la liste de pièce capturées correspondante
                        j1.ajouterPieceCapturee(pieceDestination);
                    } else if (!pieceDestination.isEstBlanc() && pieceDestination.isEstCapturee()){
                        j2.ajouterPieceCapturee(pieceDestination);
                    }
                    echiquier.setCaseParPosition(pFrom, pTo);//déplace la pièce
                    grille.creerGrille(); //update la grille
                    if (pieceDestination.getClass() == Roi.class) {
                        // win
                        return ResultatManche.ECHEC; //si la pièce capturée est un roi, retourne echec
                    }
                    return ResultatManche.CAPTURE; //si la pièce capturée est pas un roi, retourne capturée
                }
                echiquier.setCaseParPosition(pFrom, pTo); //si rien n'st capturé, retourne déplacement
                return ResultatManche.DEPLACEMENT;
            } else {
                return ResultatManche.INVALIDE; //si rien n'arive, alors mouv invalide
            }
        }
        return ResultatManche.INVALIDE; //si la case de départ a rien, mouv invalide
    }


}

