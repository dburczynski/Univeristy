package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane okno = new GridPane();

        primaryStage.initStyle(StageStyle.UNDECORATED);
        Menu menu = new Menu("Menu");
        MenuItem test = new MenuItem("Test");
        MenuItem lekarze = new MenuItem("Lekarze");
        MenuItem wizyta = new MenuItem("Wizyta");

        VBox v2 = new VBox();
        v2.setMinWidth(200);
        v2.setAlignment(Pos.TOP_RIGHT);
        okno.add(v2,1,     1,1,1);


        TextField pacjent = new TextField();
        pacjent.setMaxWidth(150);
        Button sprawdz = new Button("Sprawdz");
        Label polaczono = new Label("Polaczono z baza danych");
        Label err1 = new Label("Blad polaczenia z baza danych");
        Label err2 = new Label("Blad sterownika");

        test.setOnAction(e-> {
            v2.getChildren().clear();
            new ConnectionClass().connect(v2,polaczono,err1,err2);
        });

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

        menu.getItems().addAll(test,lekarze,wizyta);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);
        okno.add(menuBar,0,0,1,1);


        primaryStage.setTitle("Przychodnia");
        primaryStage.setScene(new Scene(okno, 800, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
