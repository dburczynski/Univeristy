package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane okno = new BorderPane();
        okno.setPadding(new Insets(30,40,30,40));
        HBox buttons = new HBox();
        Button wyjscie = new Button("Wyjscie");
        Button zwin = new Button("Zwin");

        Controller controller = new Controller(okno);
        buttons.getChildren().addAll(zwin,wyjscie);
        okno.setRight(buttons);


        wyjscie.setOnAction(e-> {
                    primaryStage.close();
                }
        );

        zwin.setOnAction(e-> {
                    ((Stage)((Button)e.getSource()).getScene().getWindow()).setIconified(true);
                }
        );



        primaryStage.setScene(new Scene(okno, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
