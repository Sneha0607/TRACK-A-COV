package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;
import softablitz.Helpline;
import softablitz.HelplineAPI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelplineController implements Initializable {
    @FXML
    private MainController mainController;
    @FXML private Label number;
    @FXML private Label number_tollfree;
    @FXML private Hyperlink email;
    @FXML private Hyperlink twitter;
    @FXML private Hyperlink facebook;
    @FXML private TableView<Helpline.HelplineData.Contacts.Regional> regionalTable;
    @FXML private TableColumn<Helpline.HelplineData.Contacts.Regional, String> state;
    @FXML private TableColumn<Helpline.HelplineData.Contacts.Regional, String> contact;

    HelplineAPI helplineAPI = new HelplineAPI();

    public void PrimaryContact() {
        try {
            Helpline response = helplineAPI.HelplineAPI();
            Helpline.HelplineData.Contacts.Primary primary = response.data.contacts.primary;
            number.setText(primary.number);
            number_tollfree.setText("1075");
            email.setText(primary.email);
            twitter.setText(primary.twitter);
            facebook.setText(primary.facebook);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void RegionalContact() {
        try {
            Helpline response = helplineAPI.HelplineAPI();
            Helpline.HelplineData.Contacts.Regional[] regional = response.data.contacts.regional;

            ObservableList<Helpline.HelplineData.Contacts.Regional> regionalData = FXCollections.observableArrayList(regional);

            regionalTable.setItems(regionalData);
            state.setCellValueFactory(new PropertyValueFactory<Helpline.HelplineData.Contacts.Regional, String>("loc"));
            contact.setCellValueFactory(new PropertyValueFactory<Helpline.HelplineData.Contacts.Regional, String>("number"));
            regionalTable.setItems(regionalData);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       PrimaryContact();
       RegionalContact();
    }
}
