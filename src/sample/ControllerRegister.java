package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerRegister {
    ConnectionClass connectionClass=new ConnectionClass();
    Connection connection=connectionClass.getConnection();
    public TextField username;
    public PasswordField password;
    public void regnow(ActionEvent actionEvent){

        try {

            Statement statement = this.connection.createStatement();
            String sqlchange = "insert into users (username,passwrod) value('"+username.getText()+"','"+password.getText()+"');";
            int rs = statement.executeUpdate(sqlchange);

        }catch (SQLException var9) {
            var9.printStackTrace();

        }
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
    public void back(ActionEvent actionEvent){

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
}
