package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;

import static javafx.scene.media.MediaPlayer.INDEFINITE;

public class Controller implements Initializable {
    public TextField newusername;
    public PasswordField newpass;
    public ImageView pepe;
    public ImageView pepe1;
    public ImageView pepe11;
    public ImageView pepe111;
    public ImageView pepe1111;
    public ImageView pepe11111;
    public ImageView pepe111111;
    public ImageView pepe1111111;
    public ImageView pepe11111111;
    public ImageView pepe111111111;
    public ImageView pepe1111111111;
    public ImageView pepe11111111111;
    public Label errormess;

    ConnectionClass cn = new ConnectionClass();
    Connection connection = cn.getConnection();
    ObservableList<Skladatelia> observableList = FXCollections.observableArrayList();

    @FXML
    TableView<Skladatelia> tableView = new TableView();
    @FXML
    TableColumn<Skladatelia, String> column_id;
    @FXML
    TableColumn<Skladatelia, String> column_name;
    @FXML
    TableColumn<Skladatelia, String> column_song;

    @Override

    public void initialize(URL location, ResourceBundle resources) {
        String contents = null;
        try {
            contents = new String(Files.readAllBytes(Paths.get("idused.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        column_id.setCellValueFactory(new PropertyValueFactory("id"));
        column_name.setCellValueFactory(new PropertyValueFactory("name"));
        column_song.setCellValueFactory(new PropertyValueFactory("Song"));

        String sql = "select * from artists where iduser = '"+contents+"' ;";
        try {
            Statement statement = connection.createStatement();
            column_id = new TableColumn<>("id");
            column_name = new TableColumn<>("Name");
            column_song = new TableColumn<>("Song");

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String song = rs.getString("song");
                observableList.add(new Skladatelia(id, name, song));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        tableView.setItems(observableList);


    }

    public void backtologin(ActionEvent actionEvent){

        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene tableViewScene = new Scene(tableViewParent);


        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();





    }
    public void changeuser(ActionEvent actionEvent){

        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("change.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene tableViewScene = new Scene(tableViewParent);


        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

    }
    public void addmusic(ActionEvent actionEvent){

        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("addmusic.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene tableViewScene = new Scene(tableViewParent);


        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

    }

    public void feelsokeyman(){
        pepe.setVisible(true);
        pepe1.setVisible(true);
        pepe11.setVisible(true);
        pepe111.setVisible(true);
        pepe1111.setVisible(true);
        pepe11111.setVisible(true);
        pepe111111.setVisible(true);
        pepe1111111.setVisible(true);
        pepe11111111.setVisible(true);
        pepe111111111.setVisible(true);
        pepe1111111111.setVisible(true);
        pepe11111111111.setVisible(true);
        final Task task = new Task() {

            @Override
            protected Object call() throws Exception {
                int s = INDEFINITE;
                AudioClip audio = new AudioClip(getClass().getResource("twitch.mp3").toExternalForm());
                audio.setVolume(0.5f);
                audio.setCycleCount(s);
                audio.play();
                return null;
            }
        };
        Thread thread = new Thread(task);
        thread.start();

    }

        public void refresh(ActionEvent actionEvent){
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
        public void tablenameonclick() {
            Skladatelia person = tableView.getSelectionModel().getSelectedItem();
            String name = person.getName();
            System.out.println(name);

            if(name.equals("Viktor Sheen")){
                errormess.setText("Viktor Sheen (* 15. srpna 1993 Kazachstán) je český rapper pocházející z Kazachstánu.");
            }
            if(name.equals("Machine Gun Kelly")){
                errormess.setText("Colson Baker (* 22. dubna 1990), známější pod pseudonymem MGK nebo Machine Gun Kelly, je americký rapper z Clevelandu v Ohiu. ");
            }
            }
        }




