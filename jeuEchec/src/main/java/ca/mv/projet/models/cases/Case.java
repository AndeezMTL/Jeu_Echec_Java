package ca.mv.projet.models.cases;

import ca.mv.projet.models.pieces.Piece;

public abstract class Case {
    private final Position posCourante;
    private Piece piece;
    private boolean estCaseBlanche;

    public Case(Position posCourante) {
        this.posCourante = posCourante; //constructeur des cases vides
        setEstCaseBlanche();
    }

    public Case(Position position, Piece piece) {
        this(position); //constructeur de cases occupées
        this.piece = piece;
    }

    public void setEstCaseBlanche() {
        this.estCaseBlanche = (posCourante.getX() + posCourante.getY()) % 2 == 0;   //setter pour est ce que la case est blanche
    }

    public boolean isEstCaseBlanche(){
        return estCaseBlanche;
    }   //getter pour voir si la case est blanche

    public Position getPosition() {
        return posCourante;
    }   //getter de la position de la case

    public Piece getPiece() {
        return piece;
    }   //getter de la pieces de la case

    public void setPiece(Piece piece) {
        this.piece = piece;
    }  //set la piece de la case

    @Override
    public String toString() {  //permets d'afficher une case en string
        return "Case{" +
                "position=" + posCourante +
                ", piece=" + piece +
                ", estCaseBlanche=" + estCaseBlanche +
                '}';
    }
}
