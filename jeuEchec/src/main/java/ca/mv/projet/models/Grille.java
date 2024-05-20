package ca.mv.projet.models;


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

    public void setAppController(AppController appController) { //set le appController de la grille
        this.appController = appController;
    }

    public void setGrid(GridPane grid) { //Set la grid de la grille
        this.grid = grid;
    }

    public void setBoardAnchorPane(AnchorPane boardAnchorPane) { //set le anchorpane (contenant pricipal)
        this.boardAnchorPane = boardAnchorPane;
    }

    public Echiquier getEchiquier() { //retourne l'échequier de la grille
        return echiquier;
    }


    public Grille(Echiquier echiquier) { //met l'échequier de la grille et crée la grille
        this.echiquier = echiquier;
        creerGrille();
    }

    public void creerGrille() {
        for (int i = 0; i < echiquier.plateau.length; i++) {
            for (int j = 0; j < echiquier.plateau[i].length; j++) {
                final int indexX = i;
                final int indexY = j; //stock la valeur x et y dans une variable temporaire pour l'utiliser dans registerUserClick
                StackPane stackPane = new StackPane(); //crée une stackpane a chaque case
                creerImageView(i, j, stackPane); //assigne une image a chaque stackPane si nécessaire
                stackPane.setOnMouseClicked(event -> { //quand on clique une case, active la méthode user click
                    appController.registerUserClick(event, indexX, indexY);
                });

                if (grid != null) {
                    grid.add(stackPane, i, j); //ajoute la stackpane à la grille
                }
            }
        }
    }

    public ImageView creerImageView(int colonne, int ligne, StackPane stackPane) {
        Case caseActuelle = echiquier.getCaseParPosition(colonne, ligne);
        stackPane.getChildren().clear(); //suprime toute les images view déja présentes
        stackPane.getStyleClass().setAll((colonne + ligne) % 2 == 0? "white-square" : "black-square"); //rends les cases "blanches" ou "noires" avec leurs position

        if (caseActuelle != null && caseActuelle.getPiece() != null) { //s'il y a une case actuelle et qu'elle a une pièce
            String path = "ca/mv/projet/PNG/" + echiquier.getCaseParPosition(colonne, ligne).getPiece().getImage(); //stock le chemin de l'image
            URL imageUrl = getClass().getResource("/" + path); //retourne l'url de l'image

            if (imageUrl != null) { //s'il y a une url
                ImageView imgPieces = new ImageView(imageUrl.toExternalForm()); //crée une image pour la pièce
                stackPane.getChildren().add(imgPieces); //ajoute l'image au stackpane
                imgPieces.fitWidthProperty().bind(stackPane.widthProperty().subtract(8));
                imgPieces.fitHeightProperty().bind(stackPane.heightProperty().subtract(8));
                return imgPieces;
            }
        }
        return null;
    }


}
