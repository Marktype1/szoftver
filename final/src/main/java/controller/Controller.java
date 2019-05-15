package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.CinemaModel;
import model.DAO.Foglalas;
import model.DAO.FoglalasDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private static Logger logger = LogManager.getLogger(Controller.class);

    private CinemaModel cinemaModel;

    String message = "";

    @FXML
    private void selectChosenMovie(ActionEvent event){

        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems();

        for(String m: movies){
            message = m;
        }
        Image img = new Image(getClass().getResource("/pictures/" + message + ".png").toExternalForm());
        imageview.setImage(img);
        cinemaModel.setFilm(message);
        placeWatcher();
    }

    @FXML
    private void chooseDate(ActionEvent event) {
        String date = dateChoice.getValue().toString();
        cinemaModel.setDatum(date);
    }

    @FXML
    public ListView<String> listView;
    ObservableList<String> list = FXCollections.observableArrayList("Avengers Endgame","Glass","IT2","Avatar","Sonic","Hulk");

    @FXML
    public ChoiceBox dateChoice;
    ObservableList<String> list1 = FXCollections.observableArrayList("Kedd 14:00","Szerda 16:00","Pentek 20:00","Szombat 22:00","Hetfo 17:00","Vasarnap 21:00");

    @FXML
    public TextField vezeteknev;

    @FXML
    public TextField keresztnev;

    @FXML
    public TextField mail;

    @FXML
    public TextField nr;

    @FXML
    public ToggleButton b11;

    @FXML
    public ToggleButton b12;

    @FXML
    public ToggleButton b13;

    @FXML
    public ToggleButton b14;

    @FXML
    public ToggleButton b15;

    @FXML
    public ToggleButton b16;

    @FXML
    public ToggleButton b21;

    @FXML
    public ToggleButton b22;

    @FXML
    public ToggleButton b23;

    @FXML
    public ToggleButton b24;

    @FXML
    public ToggleButton b25;

    @FXML
    public ToggleButton b26;

    @FXML
    public ToggleButton b31;

    @FXML
    public ToggleButton b32;

    @FXML
    public ToggleButton b33;

    @FXML
    public ToggleButton b34;

    @FXML
    public ToggleButton b35;

    @FXML
    public ToggleButton b36;

    @FXML
    public ToggleButton b41;

    @FXML
    public ToggleButton b42;

    @FXML
    public ToggleButton b43;

    @FXML
    public ToggleButton b44;

    @FXML
    public ToggleButton b45;

    @FXML
    public ToggleButton b46;

    @FXML
    public ToggleButton b51;

    @FXML
    public ToggleButton b52;

    @FXML
    public ToggleButton b53;

    @FXML
    public ToggleButton b54;

    @FXML
    public ToggleButton b55;

    @FXML
    public ToggleButton b56;


    @FXML
    public ImageView imageview = new ImageView();

    public boolean[] foglalt;
    int placeId = 0;
    @FXML
    private void foglalAction(javafx.event.ActionEvent actionEvent) {


        logger.info("foglalAction-ben");
        logger.info(vezeteknev.getText(), keresztnev.getText(),mail.getText(), nr.getText());
        cinemaModel.foglalas(vezeteknev.getText(), keresztnev.getText(), mail.getText(), nr.getText(), placeId);
    }

    FoglalasDAO foglalasDAO=new FoglalasDAO();
    public ToggleButton[] arrayButtons;

    public void placeWatcher(){
        populateArrayButton();
        for (ToggleButton toggle : arrayButtons){
            toggle.setSelected(false);
            String d=dateChoice.getValue().toString();
            List<Integer> place=foglalasDAO.readSzamitas(message,d);
            for(int i : place){
                if (i==Integer.parseInt(toggle.getId().substring(1))){
                    toggle.setSelected(true);
                }
            }
        }
    }

    public void populateArrayButton(){
        arrayButtons = new ToggleButton[30];
        arrayButtons[0] = b11;
        arrayButtons[1] = b12;
        arrayButtons[2] = b13;
        arrayButtons[3] = b14;
        arrayButtons[4] = b15;
        arrayButtons[5] = b16;

        arrayButtons[6] = b21;
        arrayButtons[7] = b22;
        arrayButtons[8] = b23;
        arrayButtons[9] = b24;
        arrayButtons[10] = b25;
        arrayButtons[11] = b26;

        arrayButtons[12] = b31;
        arrayButtons[13] = b32;
        arrayButtons[14] = b33;
        arrayButtons[15] = b34;
        arrayButtons[16] = b35;
        arrayButtons[17] = b36;

        arrayButtons[18] = b41;
        arrayButtons[19] = b42;
        arrayButtons[20] = b43;
        arrayButtons[21] = b44;
        arrayButtons[22] = b45;
        arrayButtons[23] = b46;

        arrayButtons[24] = b51;
        arrayButtons[25] = b52;
        arrayButtons[26] = b53;
        arrayButtons[27] = b54;
        arrayButtons[28] = b55;
        arrayButtons[29] = b56;
    }


    ToggleButton ptoggleButton;

    @FXML
    public void toggledButton(ActionEvent actionEvent){
        String id = actionEvent.getSource().toString();
        ToggleButton toggleButton = (ToggleButton) actionEvent.getSource();
        int i=id.indexOf("'");
        int j=id.indexOf("'",i+1);
        id=id.substring(i+1,j);
        setPlaceId(Integer.parseInt(id));
        if (toggleButton.isSelected()){
            if (ptoggleButton!=null){
                ptoggleButton.setSelected(false);
            }
            ptoggleButton=toggleButton;
        }
        String d=dateChoice.getValue().toString();
        List<Integer> place=foglalasDAO.readSzamitas(message,d);
        for(int k : place){
            if (k==Integer.parseInt(toggleButton.getId().substring(1))){
                toggleButton.setSelected(true);
            }
        }
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(list);
        dateChoice.setItems(list1);

        cinemaModel = new CinemaModel();
    }

}