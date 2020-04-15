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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerChange {
    public PasswordField newpass;

    public TextField newuser;
    ConnectionClass cn = new ConnectionClass();
    Connection connection = cn.getConnection();


    public void change(ActionEvent actionEvent){


              try {
                  String contents = null;
                  try {
                      contents = new String(Files.readAllBytes(Paths.get("idused.txt")));
                  } catch (IOException e) {
                      e.printStackTrace();
                  }

                  Statement statement = this.connection.createStatement();
                  String sqlchange = "UPDATE users SET username = '" + newuser.getText() + "', passwrod = '" + newpass.getText() + "' WHERE id = " + contents + ";";
                  int rs = statement.executeUpdate(sqlchange);

                  System.out.println("- Your login data have been updated, your nick is : " + newuser.getText() + "");
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

              } catch (SQLException var9) {
                  var9.printStackTrace();

              }

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

