package ca.mv.projet;

import ca.mv.projet.models.cases.Position;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    // TODO: remplacer par le code approprié

    private Jeu jeu;

    @FXML private Label j1Label;
    @FXML private Label j2Label;

    //faire le calcul pour remplir la valeur pfrom et pTo
    @FXML public void doMove(ActionEvent event) {
        Position pFrom = null;
        Position pTo = null;
        jeu.executeMove(pFrom, pTo);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.jeu = new Jeu();
        j1Label.setText(Utilities.j1_name);
        j2Label.setText(Utilities.j2_name);
    }
}