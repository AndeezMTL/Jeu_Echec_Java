package ca.mv.projet;

import ca.mv.projet.models.Grille;
import ca.mv.projet.models.Joueur;
import ca.mv.projet.models.Echiquier;

public class Jeu {
    // TODO: ajouter le code manquant
    Echiquier echiquier;
    Joueur j1;
    Joueur j2;
    Grille grille;

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

}
