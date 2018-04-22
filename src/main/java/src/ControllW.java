package src;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ControllW {
    ObservableList<String> TownyList = FXCollections.observableArrayList(
            "Default city", "City 17", "Saints-Peterburg", "Smolensk", "San-Francisco", "Orenburg", "Ufa", "Vladivostok", "Sochi", "Orsk", "London");
    HashMap<String, WeatherCity> Towns = new HashMap<>();

    @FXML
    private ChoiceBox someparam1;
    @FXML
    private ChoiceBox someparam2;
    @FXML
    private ChoiceBox ChoiceTown;
    @FXML
    private Text TextSts;
    @FXML
    private Button SomeFunc1;
    @FXML
    private DatePicker PickDate;
    @FXML

    //@Override
    private void initialize ()
    {
        ChoiceTown.setValue("City 17");
        ChoiceTown.setItems(TownyList);
        PickDate.setValue(LocalDate.now());
        TextSts.setText("+-5");

    }
    public void ActionSomeFunc1 (ActionEvent actionEvent)
    {
        TextSts.setText("-+0");
    }
    public void ActionSomeFunc2 (ActionEvent actionEvent)
    {
        TextSts.setText("+-0");
    }
}
