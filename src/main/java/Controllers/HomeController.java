package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import softablitz.HomeAPI;
import softablitz.Home;
import softablitz.SQLConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML private MainController mainController;

    @FXML private Label indiaConfirmed;
    @FXML private Label indiaRecovered;
    @FXML private Label indiaDeaths;

    HomeAPI homeAPI = new HomeAPI();

    public void showData() {
        try {
            Connection connection = SQLConnection.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("Select * from HOME");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Home response = homeAPI.HomeAPI();
            Home data = response;
            indiaConfirmed.setText(String.valueOf(data.totalCases));
            indiaRecovered.setText(String.valueOf(data.recovered));
            indiaDeaths.setText(String.valueOf(data.deaths));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
