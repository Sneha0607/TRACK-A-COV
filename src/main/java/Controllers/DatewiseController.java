package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import softablitz.DatewiseSQL;
import softablitz.HelplineSQL;
import softablitz.SQLConnection;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class DatewiseController implements Initializable {
    @FXML private DatePicker datePicker;
    @FXML private TableView<DateList> datewiseTable;
    @FXML private TableColumn<DateList, String> date;
    @FXML private TableColumn<DateList, Integer> confirmed;
    @FXML private TableColumn<DateList, Integer> recovered;
    @FXML private TableColumn<DateList, Integer> deaths;
    @FXML private Label TimeStamp;

    public class DateList{
        String Date;
        int total;
        int recovered;
        int deaths;

        public DateList(String date, int total, int recovered, int deaths) {
            this.Date = date;
            this.total = total;
            this.recovered = recovered;
            this.deaths = deaths;
        }

        public String getDate() {
            return Date;
        }

        public int getTotal() {
            return total;
        }

        public int getRecovered() {
            return recovered;
        }

        public int getDeaths() {
            return deaths;
        }
    }
    public void showData(){
        try {
            DateList[] dateList = new DateList[0];
            Connection connection = SQLConnection.getConnection();
            ObservableList<DateList> dateListObservableList = FXCollections.observableArrayList(dateList);
            ResultSet resultSet = connection.createStatement().executeQuery("Select * from Datewisenational");
            while (resultSet.next()) {
                dateListObservableList.add(new DateList(resultSet.getString("Date"),
                        resultSet.getInt("Total"),
                        resultSet.getInt("Recovered"),
                        resultSet.getInt("Deaths")));
            }

            Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getTime());
            String timeStampString = timestamp.toString();
            TimeStamp.setText(timeStampString);

            date.setCellValueFactory(new PropertyValueFactory<DateList, String>("date"));
            confirmed.setCellValueFactory(new PropertyValueFactory<DateList, Integer>("total"));
            recovered.setCellValueFactory(new PropertyValueFactory<DateList, Integer>("recovered"));
            deaths.setCellValueFactory(new PropertyValueFactory<DateList, Integer>("deaths"));
            datewiseTable.setItems(dateListObservableList);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void handleBtnRefreshAction(ActionEvent actionEvent) throws IOException, InterruptedException, URISyntaxException {
        DatewiseSQL datewiseSQL = new DatewiseSQL();
        datewiseSQL.DatewiseSQL();
        showData();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        showData();
    }
}