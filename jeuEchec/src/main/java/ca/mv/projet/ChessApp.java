package ca.mv.projet;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.Grille;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import java.io.IOException;
import java.util.Scanner;

public class ChessApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChessApp.class.getResource("/ca/mv/projet/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Utilities.SCENE_WIDTH, Utilities.SCENE_HIEGHT);
        AppController appController = fxmlLoader.getController();


        stage.setTitle(Utilities.APP_TITLE);
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nom du joueur 1 : ");
        Utilities.j1_name = scanner.nextLine();
        System.out.print("Nom du joueur 2 : ");
        Utilities.j2_name = scanner.nextLine();
        System.out.println();
        scanner.close();
        launch();
    }
}