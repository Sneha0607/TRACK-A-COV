package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import softablitz.DatewiseSQL;
import softablitz.HomeAPI;
import softablitz.Home;
import softablitz.HomeSQL;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML private Label indiaConfirmed;
    @FXML private Label indiaRecovered;
    @FXML private Label indiaDeaths;
    @FXML private LineChart<String, Integer> lineChart;
    @FXML private Label TimeStamp;


    HomeAPI homeAPI = new HomeAPI();
    public void loadGraph() {
        String query = "SELECT DATE, TOTAL FROM DATEWISENATIONAL";
        XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "Sneha@0607");
            statement = connection.createStatement();
            statement.executeUpdate("USE COVIDDATABASE");
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            while(resultSet.next()) {
                series.getData().add(new XYChart.Data<String, Integer>(resultSet.getString("Date"), resultSet.getInt("Total")));
            }
            lineChart.getData().add(series);

            Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getTime());
            String timeStampString = timestamp.toString();
            TimeStamp.setText(timeStampString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(connection!=null){
                    connection.close();
                }
            }catch (SQLException e1){
                e1.printStackTrace();
            }
        }
    }

    public void handleBtnRefreshAction(ActionEvent actionEvent) throws IOException, InterruptedException, URISyntaxException {
        HomeSQL.HomeSQL();
        loadGraph();
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
        loadGraph();
    }
}
