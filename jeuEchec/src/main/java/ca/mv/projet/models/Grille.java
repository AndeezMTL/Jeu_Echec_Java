package ca.mv.projet.models;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Grille {

    private final Echiquier echiquier;
    @FXML GridPane grid;
    @FXML AnchorPane boardAnchorPane;
    // TODO: ajouter les attributs manquants
    // lesquels?

    public Grille(Echiquier echiquier) {
        creerGrille();
        this.echiquier = echiquier;
    }

    private void creerGrille() {
        // TODO: ajouter le code approprié
    }

    public ImageView creerImageView(int colonne, int ligne, StackPane stackPane) {
        ImageView imgPieces = new ImageView((getClass().getResource("images/pieces/" +
                echiquier.getCaseParPosition(ligne, colonne).getPiece()
                        .getImage()).toExternalForm()));
        stackPane.getChildren().add(imgPieces);
        imgPieces.fitWidthProperty().bind(stackPane.widthProperty().subtract(8));
        imgPieces.fitHeightProperty().bind(stackPane.heightProperty().subtract(8));

        return imgPieces;
    }

    // TODO: ajouter les méthodes manquantes
}
