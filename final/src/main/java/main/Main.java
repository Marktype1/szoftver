package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DAO.FoglalasDAO;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        primaryStage.setTitle("CineMain");
        primaryStage.setScene(new Scene(root, 600, 400));
        Platform.runLater(root::requestFocus);
        primaryStage.setOnCloseRequest(e -> FoglalasDAO.close());
        primaryStage.show();
    }


}
