package ca.mv.projet.models;

import java.util.ArrayList;
import ca.mv.projet.models.pieces.Piece;
import java.util.List;

public class Joueur {
    private String nom;
    private boolean estBlanc;
    private List<Piece> piecesCapturees;

    public Joueur(String nom, boolean estBlanc){
        this.nom = nom;
        this.estBlanc = estBlanc;
        this.piecesCapturees = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public boolean isEstBlanc() {
        return estBlanc;
    }

    public List<Piece> getPiecesCapturees() {
        return piecesCapturees;
    }

    public void ajouterPieceCapturee(Piece piece) {
        piecesCapturees.add(piece);
    }

}
