package sample;

import javafx.scene.layout.VBox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Label;

public class ConnectionClass {

    private Connection con;

    public void connect(VBox v1) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.con = DriverManager.getConnection("jdbc:sqlserver://153.19.7.13:1401", "dburczynski", "253904");
        }

        catch(ClassNotFoundException error_sterownik) {
            v1.getChildren().clear();
            v1.getChildren().addAll(new Label("Brak Sterownika"));
        }
        catch(SQLException error_polaczenie) {
            v1.getChildren().clear();
            v1.getChildren().addAll(new Label("Blad Polaczenia"));
        }

    }

    public void closeConnection(VBox v1) {
        try {
            this.con.close();
        }

        catch(Exception e) {
            v1.getChildren().clear();
            v1.getChildren().addAll(new Label("Nie mozna zerwac polaczenia"));
        }
    }
    public Connection getCon() {
        return con;
    }

}
