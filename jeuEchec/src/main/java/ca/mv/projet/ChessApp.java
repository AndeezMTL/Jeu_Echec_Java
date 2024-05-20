package ca.mv.projet;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.application.Application;
import java.io.IOException;
import java.util.Scanner;

public class ChessApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChessApp.class.getResource("/ca/mv/projet/hello-view.fxml")); //load le fxml de l'app
        Scene scene = new Scene(fxmlLoader.load(), Utilities.SCENE_WIDTH, Utilities.SCENE_HIEGHT);
        AppController appController = fxmlLoader.getController(); //set le appcontroller celui retourné par ce getteur
        GridPane grid = (GridPane) scene.getRoot().lookup("#grid");
        appController.setGrid(grid); //set la grille du controller a celle obtenue a partir du fxml
        stage.setTitle(Utilities.APP_TITLE); // mets le nom de l'app
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //crée un scanner qui prends le nom des jours
        System.out.print("Nom du joueur 1 : ");
        Utilities.j1_name = scanner.nextLine();
        System.out.print("Nom du joueur 2 : ");
        Utilities.j2_name = scanner.nextLine();
        System.out.println();
        scanner.close();
        launch(); //lance l'app

    }
}