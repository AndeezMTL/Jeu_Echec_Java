package ca.mv.projet;

import ca.mv.projet.models.Grille;
import ca.mv.projet.models.cases.Position;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    // TODO: remplacer par le code approprié

    private Jeu jeu;
    private Grille grille;
    @FXML private GridPane grid;
    @FXML private AnchorPane boardAnchorPane;
    @FXML private Label j1Label;
    @FXML private Label j2Label;
    private Position posCourante = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.jeu = new Jeu();
        this.grille = new Grille(jeu.getEchiquier());
        this.grille.setAppController(this);
        this.grille.setGrid(grid);
        this.grille.setBoardAnchorPane(boardAnchorPane);
        j1Label.setText(Utilities.j1_name);
        j2Label.setText(Utilities.j2_name);

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                StackPane cases = new StackPane();
                cases.setStyle((y + x) % 2 == 0 ? "-fx-background-color: #f0d9b5;" : "-fx-background-color: #b58863;");
                cases.setOnMouseClicked(event -> registerUserClick(event));
                grid.add(cases, x, y);
            }
        }
    }

    @FXML public void registerUserClick(MouseEvent event) {
        StackPane clickedPane = (StackPane) event.getSource();
        int x = GridPane.getColumnIndex(clickedPane);
        int y = GridPane.getRowIndex(clickedPane);
        Position positionDepart = new Position(x, y);

        if (posCourante == null) {
            if (jeu.getEchiquier().estOccupe(positionDepart)) {
                posCourante = positionDepart;
            }
            else {
                Position positionDestination = positionDepart;
                if (!positionDepart.equals(positionDestination)){
                    jeu.mancheJouee(posCourante, positionDestination);
                }
                posCourante = null;
            }
        }
    }

    private void refreshBoard() {
        grid.getChildren().clear();
        grille.creerGrille();
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }
}