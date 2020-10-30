package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import softablitz.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class DistrictController implements Initializable {
    @FXML private ComboBox<String> SelectState;
    @FXML private TextField SearchDistrict;
    @FXML private TableView<District.StateData.DistrictData> DistrictTable;
    @FXML private TableColumn<District.StateData, String> State;
    @FXML private TableColumn<District.StateData.DistrictData, String> District;
    @FXML private TableColumn<softablitz.District.StateData.DistrictData, Integer> Confirmed;
    @FXML private TableColumn<District.StateData.DistrictData, Integer> Recovered;
    @FXML private TableColumn<District.StateData.DistrictData, Integer> Deaths;
    @FXML private Label TimeStamp;

    DistrictAPI districtAPI = new DistrictAPI();

    public void showData(){
        try{
           // District response = districtAPI.DistrictAPI();
            //District.StateData[] stateData= response.stateData;
            //System.out.println(response.stateData);
            /*for(softablitz.District.StateData stateData1 : response.stateData) {
                State.setCellValueFactory(new PropertyValueFactory<District.StateData, String>("state"));
                District.StateData.DistrictData[] districtData = stateData1.districtData;
                ObservableList<District.StateData.DistrictData> districtDataObservableList= FXCollections.observableArrayList(districtData);
                District.setCellValueFactory(new PropertyValueFactory<District.StateData.DistrictData, String>("name"));
                Confirmed.setCellValueFactory(new PropertyValueFactory<District.StateData.DistrictData, Integer>("confirmed"));
                Recovered.setCellValueFactory(new PropertyValueFactory<District.StateData.DistrictData, Integer>("recovered"));
                Deaths.setCellValueFactory(new PropertyValueFactory<District.StateData.DistrictData, Integer>("deaths"));
                DistrictTable.setItems(districtDataObservableList);

                Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getTime());
                String timeStampString = timestamp.toString();
                TimeStamp.setText(timeStampString);
            }*/
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void handleBtnRefreshAction(ActionEvent actionEvent) throws IOException, InterruptedException, URISyntaxException {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        showData();
    }

}
