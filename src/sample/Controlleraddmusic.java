package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Controlleraddmusic {
    public TextField artist;
    public TextField song;
    ConnectionClass cn = new ConnectionClass();
    Connection connection = cn.getConnection();


public void addmusic(ActionEvent actionEvent){
    String contents = null;
    try {
        contents = new String(Files.readAllBytes(Paths.get("idused.txt")));
    } catch (IOException e) {
        e.printStackTrace();
    }
    try {

        Statement statement = this.connection.createStatement();
        String sqlchange = "insert into artists (name,song,iduser) value('"+artist.getText()+"','"+song.getText()+"','"+contents+"');";
        int rs = statement.executeUpdate(sqlchange);

    }catch (SQLException var9) {
        var9.printStackTrace();

    }
    Parent tableViewParent = null;
    try {
        tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
    } catch (IOException e) {
        e.printStackTrace();
    }
    Scene tableViewScene = new Scene(tableViewParent);


    Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

    window.setScene(tableViewScene);
    window.show();



}

public void deletemusic(ActionEvent actionEvent){
    String contents = null;
    try {
        contents = new String(Files.readAllBytes(Paths.get("idused.txt")));
    } catch (IOException e) {
        e.printStackTrace();
    }
    try {

        Statement statement = this.connection.createStatement();
        String sqlchange = "DELETE FROM artists WHERE name = '"+artist.getText()+"' and song ='"+song.getText()+"'and iduser ='"+contents+"';";
        int rs = statement.executeUpdate(sqlchange);



    }catch (SQLException var9) {
        var9.printStackTrace();

    }
    Parent tableViewParent = null;
    try {
        tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
    } catch (IOException e) {
        e.printStackTrace();
    }
    Scene tableViewScene = new Scene(tableViewParent);


    Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

    window.setScene(tableViewScene);
    window.show();



}
    public void back(ActionEvent actionEvent){
        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene tableViewScene = new Scene(tableViewParent);


        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();




    }

}