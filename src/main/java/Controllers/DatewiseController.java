package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import softablitz.Datewise;
import softablitz.DatewiseAPI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DatewiseController implements Initializable {
    @FXML private TableView<Datewise.DatewiseData> datewiseTable;
    @FXML private TableColumn<Datewise.DatewiseData, String> date;
    @FXML private TableColumn<Datewise.DatewiseData.Summary, Integer> confirmed;
    @FXML private TableColumn<Datewise.DatewiseData.Summary, Integer> recovered;
    @FXML private TableColumn<Datewise.DatewiseData.Summary, Integer> deaths;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatewiseAPI datewiseAPI = new DatewiseAPI();
        Datewise response = null;
        try {
            response = datewiseAPI.DatewiseAPI();
            Datewise.DatewiseData[] national = response.data;

            ObservableList<Datewise.DatewiseData> summaryObservableList = FXCollections.observableArrayList(national);
            date.setCellValueFactory(new PropertyValueFactory<Datewise.DatewiseData, String>("day"));
            confirmed.setCellValueFactory(new PropertyValueFactory<Datewise.DatewiseData.Summary, Integer>("total"));
            recovered.setCellValueFactory(new PropertyValueFactory<Datewise.DatewiseData.Summary, Integer>("discharged"));
            deaths.setCellValueFactory(new PropertyValueFactory<Datewise.DatewiseData.Summary, Integer>("deaths"));
            datewiseTable.setItems(summaryObservableList);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
