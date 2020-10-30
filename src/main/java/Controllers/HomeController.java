package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import softablitz.HomeAPI;
import softablitz.Home;
import softablitz.HomeSQL;
import softablitz.SQLConnection;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML private MainController mainController;

    @FXML private Label indiaConfirmed;
    @FXML private Label indiaRecovered;
    @FXML private Label indiaDeaths;
    @FXML private Label TimeStamp;
    @FXML private BarChart<String, String> barChart;

    HomeAPI homeAPI = new HomeAPI();

    public void showData() {
        try {
            Connection connection = SQLConnection.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("Select * from HOME");

            Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getTime());
            String timeStampString = timestamp.toString();
            TimeStamp.setText(timeStampString);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void handleBtnRefreshAction(ActionEvent actionEvent) throws IOException, InterruptedException, URISyntaxException {
        HomeSQL homeSQL = new HomeSQL();
        homeSQL.HomeSQL();
        showData();
        loadTable();
    }

    public void loadTable() {
        String query = "SELECT DATE, TOTAL FROM DATEWISENATIONAL";
        XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
        try {
            Connection connection = SQLConnection.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            while(resultSet.next()) {
                series.getData().add(new XYChart.Data<>(resultSet.getString(1), resultSet.getInt(2)));
            }
            barChart.getData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loadTable();

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
