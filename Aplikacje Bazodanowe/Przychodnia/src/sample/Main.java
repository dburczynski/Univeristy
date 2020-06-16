package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        GridPane okno = new GridPane();

        VBox v1 = new VBox();
        v1.setMinWidth(200);
        v1.setAlignment(Pos.TOP_LEFT);
        okno.add(v1,0,0,1,4);

        VBox v2 = new VBox();
        v2.setMinWidth(200);
        v2.setAlignment(Pos.TOP_RIGHT);
        okno.add(v2,1,0,1,1);

        Button test = new Button("Test");
        Button lekarze = new Button("Lekarze");
        Button wizyta = new Button("Wizyta");
        Button sprawdz = new Button("Sprawdz");
        v1.getChildren().addAll(test,lekarze,wizyta);

        TextField pacjent = new TextField();
        pacjent.setMaxWidth(150);

        Label polaczono = new Label("Polaczono z baza danych");
        Label err1 = new Label("Blad polaczenia z baza danych");
        Label err2 = new Label("Blad sterownika");

        test.setOnAction(e-> {
            v2.getChildren().clear();
            new ConnectionClass().connect(v2,polaczono,err1,err2);
        }
        );

        lekarze.setOnAction(e-> {
            v2.getChildren().clear();
            new ConnectionClass().showLekarze(v2,err1,err2);

        }

        );

        wizyta.setOnAction(e-> {
            v2.getChildren().clear();
            v2.getChildren().addAll(pacjent,sprawdz);

        }
        );

        sprawdz.setOnAction(e-> {
            v2.getChildren().clear();
            new ConnectionClass().findWizyta(v2,err1,err2,pacjent);
        }
        );


        primaryStage.setTitle("Przychodnia");
        primaryStage.setScene(new Scene(okno, 800, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
