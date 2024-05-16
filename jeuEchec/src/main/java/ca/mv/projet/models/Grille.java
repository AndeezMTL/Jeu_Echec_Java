package ca.mv.projet.models;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import ca.mv.projet.models.cases.Case;

public class Grille {

    private final Echiquier echiquier;
    @FXML GridPane grid;
    @FXML AnchorPane boardAnchorPane;
    // TODO: ajouter les attributs manquants
    // lesquels?

    public Grille(Echiquier echiquier) {
        this.echiquier = echiquier;
        creerGrille();
    }

    private void creerGrille() {
        for (int i = 0; i < echiquier.plateau.length; i++) {
            for (int j = 0; j < echiquier.plateau[i].length; j++) {
                StackPane stackPane = new StackPane();
                stackPane.getStyleClass().add(echiquier.plateau[i][j].isEstCaseBlanche() ? "white-square" : "black-square" );
                creerImageView(i, j, stackPane);
                if (boardAnchorPane != null) {
                    if (grid != null) {grid.add(stackPane, j, i);}
                }
            }
        }
    }

    public ImageView creerImageView(int colonne, int ligne, StackPane stackPane) {
        ImageView imgPieces = new ImageView((getClass().getResource("ca/mv/projet/PNG" +
                echiquier.getCaseParPosition(ligne, colonne).getPiece()
                        .getImage()).toExternalForm()));
        stackPane.getChildren().add(imgPieces);
        imgPieces.fitWidthProperty().bind(stackPane.widthProperty().subtract(8));
        imgPieces.fitHeightProperty().bind(stackPane.heightProperty().subtract(8));

        return imgPieces;
    }

    // TODO: ajouter les méthodes manquantes
}
