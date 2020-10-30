package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import softablitz.Notifications;
import softablitz.NotificationsSQL;
import softablitz.SQLConnection;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class NotificationsController implements Initializable {
    @FXML private TableView<Notifications.LatestData.NotificationsData> notificationsTable;
    @FXML private TableColumn<Notifications.LatestData.NotificationsData, String> title;
    @FXML private TableColumn<Notifications.LatestData.NotificationsData, String> link;
    @FXML private TableColumn bookmark;
    @FXML private TableView<Notifications.LatestData.NotificationsData> bookmarkTable;
    @FXML private TableColumn<Notifications.LatestData.NotificationsData, String> titleBookmark;
    @FXML private TableColumn<Notifications.LatestData.NotificationsData, String> linkBookmark;
    @FXML private Label TimeStamp;

    public void showData()
    {
        try {
            Notifications.LatestData.NotificationsData[] notificationsData = new Notifications.LatestData.NotificationsData[0];
            Connection connection = SQLConnection.getConnection();
            ObservableList<Notifications.LatestData.NotificationsData> notificationsDataObservableList  = FXCollections.observableArrayList(notificationsData);
            ResultSet resultSet = connection.createStatement().executeQuery("Select * from NOTIFICATIONS");
            while(resultSet.next()){
                notificationsDataObservableList.add(new Notifications.LatestData.NotificationsData(resultSet.getString("Title"),(resultSet.getString("Link"))));
            }
            Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getTime());
            String timeStampString = timestamp.toString();
            TimeStamp.setText(timeStampString);

            title.setCellValueFactory(new PropertyValueFactory<Notifications.LatestData.NotificationsData, String>("Title"));
            link.setCellValueFactory(new PropertyValueFactory<Notifications.LatestData.NotificationsData, String>("Link"));
            notificationsTable.setItems(notificationsDataObservableList);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showData();
    }

    public void handleBtnRefreshAction(ActionEvent actionEvent) throws IOException, InterruptedException, URISyntaxException {
        NotificationsSQL notificationsSQL = new NotificationsSQL();
        notificationsSQL.NotificationsSQL();
        showData();
    }
}
