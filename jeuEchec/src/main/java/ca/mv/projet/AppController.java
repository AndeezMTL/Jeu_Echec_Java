package ca.mv.projet;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.Grille;
import ca.mv.projet.models.cases.Position;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
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
    public void initialize(URL url, ResourceBundle resourceBundle) { //crée le jeu et utilise son échequier et grille associés. Prend la grid de la grille et l'assigne son anchorpane. Crée les joueurs et initialise la grille
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
        Position positionClicked = new Position(x, y); //prends la position de la case cliquée
        if (posCourante == null) { //si c'est le 1er click, la position de départ = la position cliquée
            positionDepart = positionClicked;
            if (jeu.getEchiquier().estOccupe(positionDepart)) { //s'il y a une pièce, la pos courante est celle cliquée
                posCourante = positionDepart;
            }
        } else {
            Position positionDestination = positionClicked; //si 2e click, position cliquée = position destination
            if (!positionDepart.equals(positionDestination)){ //si les positions de départ et d'arrivée son différentes
                jeu.mancheJouee(posCourante, positionDestination); //fait l'action de la position de la pièce vers la destination
            }
            posCourante = null; //remets la position de pièce a null
        }
    }

    public void setGrid(GridPane grid) {
        this.grid = grid;
    }
}