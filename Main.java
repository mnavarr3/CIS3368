package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//initiates the app.....keep it minimal


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //root is the backdrop
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //main window title
        primaryStage.setTitle("Employee Manager 3000");

        //how much of main window will be taken up
        primaryStage.setScene(new Scene(root, 800, 275));

        //turn on the lights for the theater production. so always call for show.
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
