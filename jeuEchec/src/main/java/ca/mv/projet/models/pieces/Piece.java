package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public abstract class Piece {
    protected final boolean estBlanc;
    protected boolean estCapturee;
    protected String image;

    public Piece(boolean estBlanc) { //constructeur par défaut des pieces
        this.estCapturee = false;
        this.estBlanc = estBlanc;
        this.image = this.getClass().getSimpleName() + (estBlanc ? "Blanc" : "") + ".png";
    }

    public void die() { //capture les pièces
        this.estCapturee = true;
    }

    public abstract boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier); //méthode par défaut de vérification de mouvement des pieces

    public boolean isEstBlanc() {
        return estBlanc;
    } //getteur couleur

    public boolean isEstCapturee() {
        return estCapturee;
    } //getteur retournant l'état d'une pièce (capturée ou non)

    public String getImage() {
        return image;
    } //get le string correspondant au nom de l'image de la pièce

    /* Code fourni dans github*/
    protected boolean bougerSurDiagonal(Position posCourante, Position posDestination, Echiquier echiquier) {
        boolean invalid = false; //si un mouvement est invalide, il vaut false

        if (this.estSurDiagonal(posCourante, posDestination)) {
            Position direction = posDestination.substract(posCourante).direction(); //direction de mouvement
            Position pos = posCourante.add(direction);

            while (!pos.equals(posDestination)) { //vérifie chaque case entre la case départ et la destination
                if (echiquier.estOccupe(pos)) { //si l'échequier est occupé a quelquepart avant la destination, retourne false
                    return invalid;
                }
                pos = pos.add(direction);
            }
            return this.peutCapturer(echiquier.getPieceAtPosition(posDestination)); //s'il y a aucun obstacle retourne est-ce que la capture est légale
        }
        return false; //si le mouvement est pas diagonal, retourne false
    }



    public boolean estMemeCouleur(Piece piece) {
        return estBlanc == piece.estBlanc; //vérifie la couleur de 2 pièces
    }

    public boolean peutCapturer(Piece pieceDestination) {
        if(pieceDestination != null) { //regarde s'il y a une pièce dans la destination
            return !estMemeCouleur(pieceDestination); //retourne true si la pièce à capturer est ennemie
        }
        return true;
    }

    public boolean bougerSurOrthogonal(Position posCourante, Position posDestination, Echiquier echiquier) { //bouger en ligne droite
        if (posDestination.getX() == posCourante.getX() || posDestination.getY() == posCourante.getY()) { //regarde si le déplacement est seulement sur l'axe y ou x (donc est en ligne droite)
            Position direction = posDestination.substract(posCourante).direction(); //direction de mouvement
            Position pos = posCourante.add(direction); //positin temporaire pour la vérification
            boolean invalid = false; //mouvement invalide = false

            while (!pos.equals(posDestination)) { //même fonctionnement que la vérification dans le mouvement diagonal
                if (echiquier.estOccupe(pos)) {
                    return invalid;
                }
                pos = pos.add(direction);
            }
            return this.peutCapturer(echiquier.getPieceAtPosition(posDestination));
        }
        return false;
    }

    public boolean estSurDiagonal(Position posCourante, Position posDestination) {
        Position mouvement = posDestination.substract(posCourante).abs();
        return mouvement.getX() == mouvement.getY(); //si le déplacement en x est équivalent que celui en y (donc une diagonale) retourne true, sinon false
    }



    @Override
    public String toString() { //print les infos d'une pièce en string
        return "Piece{" +
                "estBlanc=" + estBlanc +
                ", estCapturee=" + estCapturee +
                ", image='" + image + '\'' +
                '}';
    }

}

