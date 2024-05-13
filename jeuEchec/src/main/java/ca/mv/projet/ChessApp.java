package ca.mv.projet;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

import java.io.IOException;
import java.util.Scanner;

public class ChessApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // TODO: remplacer par le code approprié
        FXMLLoader fxmlLoader = new FXMLLoader(ChessApp.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Utilities.SCENE_WIDTH, Utilities.SCENE_HIEGHT);
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