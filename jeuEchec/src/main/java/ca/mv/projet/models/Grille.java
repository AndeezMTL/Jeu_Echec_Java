package ca.mv.projet.models;

import ca.mv.projet.models.cases.Position;
import ca.mv.projet.models.pieces.Piece;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import ca.mv.projet.models.cases.Case;
import ca.mv.projet.AppController;
import java.net.URL;


public class Grille {

    private final Echiquier echiquier;
    @FXML private GridPane grid;
    @FXML private AnchorPane boardAnchorPane;
    private AppController appController;

    public void setAppController(AppController appController) {
        this.appController = appController;
    }

    public void setGrid(GridPane grid) {
        this.grid = grid;
    }

    public GridPane getGrid() {
        return grid;
    }

    public void setBoardAnchorPane(AnchorPane boardAnchorPane) {
        this.boardAnchorPane = boardAnchorPane;
    }

    public Echiquier getEchiquier() {
        return echiquier;
    }


    public Grille(Echiquier echiquier) {
        this.echiquier = echiquier;
        creerGrille();
    }

    public void creerGrille() {
        for (int i = 0; i < echiquier.plateau.length; i++) {
            for (int j = 0; j < echiquier.plateau[i].length; j++) {
                final int indexX = i;
                final int indexY = j;
                StackPane stackPane = new StackPane();
                creerImageView(i, j, stackPane);
                stackPane.setOnMouseClicked(event -> {
                    appController.registerUserClick(event, indexX, indexY);
                });
                if (grid != null) {
                    grid.add(stackPane, i, j);
                }
            }
        }
    }

    public ImageView creerImageView(int colonne, int ligne, StackPane stackPane) {
        Case caseActuelle = echiquier.getCaseParPosition(ligne, colonne);
        stackPane.getChildren().clear();
        Position pos = new Position(ligne, colonne);
        stackPane.getStyleClass().setAll(echiquier.getCaseParPosition(pos).isEstCaseBlanche() ? "white-square" : "black-square" );

        if (caseActuelle != null && caseActuelle.getPiece() != null) {
            String path = "ca/mv/projet/PNG/" + echiquier.getCaseParPosition(ligne, colonne).getPiece().getImage();
            URL imageUrl = getClass().getResource("/" + path);
            if (imageUrl != null) {
                ImageView imgPieces = new ImageView(imageUrl.toExternalForm());
                stackPane.getChildren().add(imgPieces);
                imgPieces.fitWidthProperty().bind(stackPane.widthProperty().subtract(8));
                imgPieces.fitHeightProperty().bind(stackPane.heightProperty().subtract(8));
                return imgPieces;
            }
        }
        return null;
    }


}
