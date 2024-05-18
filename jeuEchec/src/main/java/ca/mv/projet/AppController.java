package ca.mv.projet;

import ca.mv.projet.models.Grille;
import ca.mv.projet.models.cases.Position;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import ca.mv.projet.models.Grille;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    // TODO: remplacer par le code approprié

    private Jeu jeu;
    private Grille grille;

    @FXML private Label j1Label;
    @FXML private Label j2Label;
    private Position posCourante = null;

    //faire le calcul pour remplir la valeur pfrom et pTo
    @FXML public void doMove(ActionEvent event) {
        Position pFrom = null;
        Position pTo = null;
        jeu.executeMove(pFrom, pTo);
    }

    @FXML public void registerUserClick(MouseEvent event, int x, int y) {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.jeu = new Jeu();
        j1Label.setText(Utilities.j1_name);
        j2Label.setText(Utilities.j2_name);
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }
}