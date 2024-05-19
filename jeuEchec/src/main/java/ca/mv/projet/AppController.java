package ca.mv.projet;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.Grille;
import ca.mv.projet.models.cases.Position;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    private  Echiquier echiquier;
    private Position posCourante = null;
    private Position positionDepart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.jeu = new Jeu();
        echiquier = jeu.getEchiquier();
        this.grille = jeu.getGrille();
        this.grille.setAppController(this);
        this.grille.setGrid(grid);
        this.grille.setBoardAnchorPane(boardAnchorPane);
        j1Label.setText(Utilities.j1_name);
        j2Label.setText(Utilities.j2_name);
        this.grille.creerGrille();

    }

    @FXML public void registerUserClick(MouseEvent event, int x, int y) {
        Position positionClicked = new Position(x, y);
        System.out.println(positionClicked);
        if (posCourante == null) {
            positionDepart = positionClicked;
            if (jeu.getEchiquier().estOccupe(positionDepart)) {
                posCourante = positionDepart;
                System.out.println(positionDepart);
            }

        } else {
            Position positionDestination = positionClicked;
            System.out.println(positionDestination);
            if (!positionDepart.equals(positionDestination)){
                jeu.mancheJouee(posCourante, positionDestination);
            }
            posCourante = null;
        }
    }

    public void refreshBoard() {
        grid.getChildren().clear();
        grille.creerGrille();
    }

    public void setGrid(GridPane grid) {
        this.grid = grid;
    }
}