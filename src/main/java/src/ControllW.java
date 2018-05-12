package src;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ControllW {
    ObservableList<String> TownyList = FXCollections.observableArrayList(
            "Moscow", "Saints-Peterburg", "Smolensk", "San-Francisco", "Orenburg", "Ufa", "Vladivostok", "Sochi", "Orsk", "London");
    ObservableList<String> StatusWeather = FXCollections.observableArrayList("Ясный", "Дождливый");

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
    private Slider SelectTemp;
    @FXML
    private TextField Inform;
    @FXML
    private void initialize()
    {
        ChoiceTown.setValue("Moscow");
        ChoiceTown.setItems(TownyList);
        PickDate.setValue(LocalDate.now());
        someparam1.setValue("Ясный");
        someparam1.setItems(StatusWeather);
        TextSts.setText(String.valueOf(SelectTemp.getValue()));
        SelectTemp.setBlockIncrement(10.0);
        SelectTemp.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {
               TextSts.setText(String.format("%.1f", newValue));
            }
        });
    }
    public void ActionSomeFunc1 (ActionEvent actionEvent) // Выводим информацию о погоде в заданном городе
    {
        TextSts.setText(String.format("%.1f", SelectTemp.getValue()));
        ChoiceTown.getValue();
        System.out.println(ChoiceTown.getValue().toString());
        WeatherCity InformMe = new WeatherCity(); //Создаем объект
        Inform.setText("Current Town: "+ChoiceTown.getValue().toString() + "\n. " + "Current Temperature: " + InformMe.getStatusWeather(ChoiceTown.getValue().toString()));

    }
    public void ActionSomeFunc2 (ActionEvent actionEvent) //
    {
        TextSts.setText(String.format("%.1f", SelectTemp.getValue()));
    }
}
