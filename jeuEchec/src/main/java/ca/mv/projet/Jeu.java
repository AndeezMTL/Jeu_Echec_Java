package ca.mv.projet;

import ca.mv.projet.models.Grille;
import ca.mv.projet.models.Joueur;
import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;
import ca.mv.projet.models.pieces.Piece;
import ca.mv.projet.models.pieces.Roi;

public class Jeu {
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
        return (this.tourDeJeux % 2) == 0;
    }

    public void mancheJouee(Position pFrom, Position pTo) {
//        if (estTourDesBlanc() && echiquier.getPieceAtPosition(pFrom).isEstBlanc()) {
//            ResultatManche manche = executeMove(pFrom, pTo);
//            switch (manche){
//                case INVALIDE : {
//                    break;
//                }
//                case DEPLACEMENT :
//                case CAPTURE : {
//                    tourDeJeux++;
//                    break;
//                }
//                case ECHEC : {
//                    System.out.println("Fin de partie. Le roi " + (echiquier.getPieceAtPosition(pTo).isEstBlanc() ? "Blanc" : "Noir") + " à été capturé.");
//                    break;
//                }
//
//            }
//
//        } else {
//            System.out.println("Ce n'est pas votre tour");
//        }
        System.out.println("mancheJouee called with positions: " + pFrom + " to " + pTo);

        Piece pieceFrom = echiquier.getPieceAtPosition(pFrom);
        if (pieceFrom == null) {
            System.out.println("No piece at the starting position: " + pFrom);
            return;
        }

        if (estTourDesBlanc() != pieceFrom.isEstBlanc()) {
            System.out.println("It's not the turn of " + (pieceFrom.isEstBlanc() ? "White" : "Black"));
            return;
        }

        System.out.println("Attempting to move " + pieceFrom.getClass().getSimpleName() + " from " + pFrom + " to " + pTo);

        ResultatManche manche = executeMove(pFrom, pTo);
        switch (manche) {
            case INVALIDE:
                System.out.println("Move invalid from " + pFrom + " to " + pTo);
                break;
            case DEPLACEMENT:
            case CAPTURE:
                System.out.println("Move successful from " + pFrom + " to " + pTo);
                tourDeJeux++;
                grille.creerGrille(); // Ensure the UI updates the grid
                break;
            case ECHEC:
                System.out.println("Game over. The " + (pieceFrom.isEstBlanc() ? "White" : "Black") + " king was captured.");
                break;
        }
    }

    public ResultatManche executeMove(Position pFrom, Position pTo) {
        Piece pieceCourante = echiquier.getPieceAtPosition(pFrom);
        Piece pieceDestination = echiquier.getPieceAtPosition(pTo);

        if (echiquier.estOccupe(pFrom)) {
            if (echiquier.estValidMouve(pFrom, pTo)) {
                if (pieceDestination != null) {
                    pieceDestination.die();
                    if (pieceDestination.getClass() == Roi.class) {
                        // win
                        grille.creerGrille();
                        echiquier.setCaseParPosition(pFrom, pTo);
                        if (pieceDestination.isEstBlanc() && pieceDestination.isEstCapturee())
                        {
                            j1.ajouterPieceCapturee(pieceDestination);
                        } else if (!pieceDestination.isEstBlanc() && pieceDestination.isEstCapturee()) {
                            j2.ajouterPieceCapturee(pieceDestination);
                        }
                        return ResultatManche.ECHEC;
                    }
                    grille.creerGrille();
                    echiquier.setCaseParPosition(pFrom, pTo);
                    return ResultatManche.CAPTURE;
                }
                echiquier.setCaseParPosition(pFrom, pTo);
                return ResultatManche.DEPLACEMENT;
            } else {
                return ResultatManche.INVALIDE;
            }
        }
        return ResultatManche.INVALIDE;
    }


}

