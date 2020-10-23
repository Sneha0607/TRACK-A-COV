package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import softablitz.HomeAPI;
import softablitz.Home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML private MainController mainController;

    @FXML private Label indiaConfirmed;
    @FXML private Label indiaRecovered;
    @FXML private Label indiaDeaths;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HomeAPI homeAPI = new HomeAPI();
        try {
            Home data = homeAPI.HomeAPI();
            indiaConfirmed.setText(String.valueOf(data.getTotalCases()));
            indiaRecovered.setText(String.valueOf(data.getRecovered()));
            indiaDeaths.setText(String.valueOf(data.getDeaths()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
