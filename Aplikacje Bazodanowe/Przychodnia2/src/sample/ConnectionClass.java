package sample;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.sql.*;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.sql.*;

public class ConnectionClass {
    private Connection con;
    public void connect(VBox v2, Label polaczono, Label err1, Label err2) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.con = DriverManager.getConnection("jdbc:sqlserver://153.19.7.13:1401","dburczynski","253904");
            v2.getChildren().addAll(polaczono);
            con.close();
        }
        catch(ClassNotFoundException error_sterownik) {
            v2.getChildren().addAll(err2);
        }
        catch(SQLException error_polaczenie) {
            v2.getChildren().addAll(err1);
        }
    }
    public void showLekarze(VBox v2, Label err1, Label err2) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.con = DriverManager.getConnection("jdbc:sqlserver://153.19.7.13:1401","dburczynski","253904");
            String sql = "select * from lekarz";
            Statement zapytanie = con.createStatement();
            ResultSet wynik_zapytania = zapytanie.executeQuery(sql);
            ResultSetMetaData wynik2 = wynik_zapytania.getMetaData();
            int ile_kolumn = wynik2.getColumnCount();
            while(wynik_zapytania.next()) {
                Label wynik = new Label();
                for(int i = 1; i<=ile_kolumn; i++) {
                    wynik.setText(wynik.getText()+wynik_zapytania.getString(i)+" ");
                }
                v2.getChildren().addAll(wynik);
            }

            con.close();
        }
        catch(ClassNotFoundException error_sterownik) {
            v2.getChildren().addAll(err2);
        }
        catch(SQLException error_polaczenie) {
            v2.getChildren().addAll(err1);
        }

    }
    public void findWizyta(VBox v2, Label err1, Label err2, TextField pacjent) {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.con = DriverManager.getConnection("jdbc:sqlserver://153.19.7.13:1401","dburczynski","253904");
            String pacjentString = pacjent.getText();
            String sql = "Select top 1 pacjent.nazwisko, wizyta.data_wizyty, lekarz.nazwisko, " +
                    "lekarz.specjalizacja, lekarz.nr_pokoju FROM wizyta LEFT JOIN pacjent on " +
                    "wizyta.id_pacjent = pacjent.id_pacjent LEFT JOIN lekarz on wizyta.id_lekarz = lekarz.id_lekarz where " +
                    "pacjent.nazwisko='"+pacjentString+"'" +
                    " order by wizyta.data_wizyty";
            Statement zapytanie = con.createStatement();
            ResultSet wynik_zapytania = zapytanie.executeQuery(sql);
            ResultSetMetaData wynik2 = wynik_zapytania.getMetaData();
            int ile_kolumn = wynik2.getColumnCount();
            while(wynik_zapytania.next()) {
                Label wynik = new Label();
                for (int i = 1; i <= ile_kolumn; i++) {
                    wynik.setText(wynik.getText() + wynik_zapytania.getString(i) + " ");
                }
                v2.getChildren().addAll(wynik);
            }
            con.close();
        }
        catch(ClassNotFoundException error_sterownik) {
            v2.getChildren().addAll(err2);
        }
        catch(SQLException error_polaczenie) {
            v2.getChildren().addAll(err1);
        }
    }
}
