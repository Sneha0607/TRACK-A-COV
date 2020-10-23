package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import softablitz.State;

public class StateController {
    @FXML private MainController mainController;

    @FXML private TableView<State> stateTable;
    @FXML private TableColumn<State, Integer> srNo;
    @FXML private TableColumn<State, String> stateUT;
    @FXML private TableColumn<State, String> confirmed;
    @FXML private TableColumn<State, String> recovered;
    @FXML private TableColumn<State, String> deaths;
}
