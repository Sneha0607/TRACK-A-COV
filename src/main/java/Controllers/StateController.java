package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import softablitz.Home;
import softablitz.HomeAPI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StateController implements Initializable {
    @FXML private MainController mainController;

    @FXML private TableView<Home.regionData> stateTable;
    @FXML private TableColumn<Home.regionData, String> stateUT;
    @FXML private TableColumn<Home.regionData, Integer> confirmed;
    @FXML private TableColumn<Home.regionData, Integer> recovered;
    @FXML private TableColumn<Home.regionData, Integer> deaths;

    HomeAPI homeAPI = new HomeAPI();

    public void showData()
    {
        try {
            Home response = homeAPI.HomeAPI();
            Home.regionData[] regionData = response.regionData;

            ObservableList<Home.regionData> regionData1 = FXCollections.observableArrayList(regionData);

            stateUT.setCellValueFactory(new PropertyValueFactory<Home.regionData, String>("region"));
            confirmed.setCellValueFactory(new PropertyValueFactory<Home.regionData, Integer>("totalInfected"));
            recovered.setCellValueFactory(new PropertyValueFactory<Home.regionData, Integer>("recovered"));
            deaths.setCellValueFactory(new PropertyValueFactory<Home.regionData, Integer>("deceased"));
            stateTable.setItems(regionData1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       showData();
    }
}
