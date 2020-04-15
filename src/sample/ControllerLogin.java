package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerLogin{

    public PasswordField password;
    public TextField username;
    public Label label;
    public Label isConnected;

    public void login(ActionEvent actionEvent) {


        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();

        try {
            Statement statement=connection.createStatement();
            String sql="SELECT * FROM users WHERE username = '"+username.getText()+"' AND passwrod = '"+password.getText()+"';";
            ResultSet resultSet=statement.executeQuery(sql);

            if (resultSet.next()) {
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

                window.setScene(tableViewScene);
                window.show();
                String id = (resultSet.getString("ID"));
                File file = new File("C:\\Users\\matej\\IdeaProjects\\Spotify V2\\idused.txt");
                if(file.delete()){

                }

                FileWriter fstream = new FileWriter("idused.txt");
                BufferedWriter out = new BufferedWriter(fstream);
                out.write(id);
                //Close the output stream
                out.close();




            }

            else {
                isConnected.setText("Not Connected");
            }



        }
        catch (SQLException | IOException e) {
            e.printStackTrace();

        }


    }
    public void register(ActionEvent actionEvent){
        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("register.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene tableViewScene = new Scene(tableViewParent);


        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();






    }


}




