package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller implements Initializable {

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
        column_id.setCellValueFactory(new PropertyValueFactory("id"));
        column_name.setCellValueFactory(new PropertyValueFactory("name"));
        column_song.setCellValueFactory(new PropertyValueFactory("Song"));
        String sql = "select * from Skladatelia;";
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


        } catch(SQLException e){
            e.printStackTrace();
        }

        tableView.setItems(observableList);
    }
}
