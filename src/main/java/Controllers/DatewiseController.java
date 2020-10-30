package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import softablitz.DatewiseSQL;
import softablitz.HomeSQL;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class DatewiseController implements Initializable {

    @FXML private Label TimeStamp;


    public void showData() {
        Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getTime());
        String timeStampString = timestamp.toString();
        TimeStamp.setText(timeStampString);
    }

    public void handleBtnRefreshAction(ActionEvent actionEvent) throws IOException, InterruptedException, URISyntaxException {
        DatewiseSQL datewiseSQL = new DatewiseSQL();
        datewiseSQL.DatewiseSQL();
        showData();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}