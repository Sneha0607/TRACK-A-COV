package Controllers;

import com.sun.javafx.logging.PlatformLogger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import softablitz.Notifications;
import softablitz.NotificationsSQL;
import softablitz.SQLConnection;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class NotificationsController implements Initializable {
    @FXML private TableView<Notifications.LatestData.NotificationsData> notificationsTable;
    @FXML private TableColumn<Notifications.LatestData.NotificationsData, String> title;
    @FXML private TableColumn<Notifications.LatestData.NotificationsData, Hyperlink> link;
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
            link.setCellValueFactory(new PropertyValueFactory<Notifications.LatestData.NotificationsData, Hyperlink>("Link"));
            //notificationsTable.setItems(notificationsDataObservableList);

            Callback<TableColumn<Notifications.LatestData.NotificationsData, String>,TableCell<Notifications.LatestData.NotificationsData, String>> cellFactory = (param) -> {
                final TableCell<Notifications.LatestData.NotificationsData, String> cell = new TableCell<Notifications.LatestData.NotificationsData, String>() {

                    //@Override
                    public void updateItem(String item, Boolean empty) {
                        super.updateItem(item, empty);
                        if(empty) {
                            setGraphic(null);
                            setText(null);
                        }
                        else {
                            final Button bookmark = new Button("Bookmark");
                            bookmark.setOnAction(event -> {
                                Notifications.LatestData.NotificationsData notificationBookmark = getTableView().getItems().get(getIndex());
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setContentText("You have clicked \n "+ notificationBookmark.getTitle()+ " " + notificationBookmark.getLink());
                                alert.show();
                            });
                            setGraphic(bookmark);
                            setText(null);
                        }
                    }
                };

                return cell;
            };

            bookmark.setCellFactory(cellFactory);

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
