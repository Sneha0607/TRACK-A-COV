package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import softablitz.Notifications;
import softablitz.NotificationsAPI;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class NotificationsController implements Initializable {
    @FXML private TableView<Notifications.LatestData.NotificationsData> notificationsTable;
    @FXML private TableColumn<Notifications.LatestData.NotificationsData, String> title;
    @FXML private TableColumn<Notifications.LatestData.NotificationsData, Hyperlink> link;
    @FXML private TableColumn bookmark;
    @FXML private TableView<Notifications.LatestData.NotificationsData> bookmarkTable;
    @FXML private TableColumn<Notifications.LatestData.NotificationsData, String> titleBookmark;
    @FXML private TableColumn<Notifications.LatestData.NotificationsData, String> linkBookmark;
    private Connection connection;
    private ObservableList<Notifications.LatestData.NotificationsData> notificationsList;

/*
    private void populateTable() throws SQLException {
        notificationsList = FXCollections.observableArrayList();
        String query = "SELECT * FROM COVIDDATABASE.NOTIFICATIONS";

        connection = dbHandler.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery(query);

        title.setCellValueFactory(new PropertyValueFactory<>("Title"));
        link.setCellValueFactory(new PropertyValueFactory<>("Link"));
        notificationsTable.setItems(notificationsList);
    }
*/

    public void NotificationsTable() {
        try {
            NotificationsAPI notificationsAPI = new NotificationsAPI();
            Notifications response = notificationsAPI.NotificationsAPI();
            Notifications.LatestData.NotificationsData[] notificationsData = response.data.notifications;

            ObservableList<Notifications.LatestData.NotificationsData> notificationsList = FXCollections.observableArrayList(notificationsData);

            title.setCellValueFactory(new PropertyValueFactory<Notifications.LatestData.NotificationsData, String>("title"));
            link.setCellValueFactory(new PropertyValueFactory<Notifications.LatestData.NotificationsData, Hyperlink>("link"));
           
            Callback<TableColumn<Notifications.LatestData.NotificationsData, String>, TableCell<Notifications.LatestData.NotificationsData, String>> cellFactory = (param) -> {
                final TableCell<Notifications.LatestData.NotificationsData, String> cell = new TableCell<Notifications.LatestData.NotificationsData, String>() {

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);

                        if(empty) {
                            setGraphic(null);
                            setText(null);
                        }
                        else {
                            final Button bookmark = new Button("Bookmark");
                            bookmark.setOnAction(event -> {

                            });
                        }
                    }

                };
                return cell;
            };
            bookmark.setCellFactory(cellFactory);

            notificationsTable.getColumns().add(bookmark);


            notificationsTable.setItems(notificationsList);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NotificationsTable();
    }
}
