package io.nekopara.fx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class NekoParaController {

    @FXML
    private Button comfirmBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button resetBtn;



    @FXML
    private void comfirmBtnAction(ActionEvent event) {
        System.out.println("You clicked comfirm!");
    }

    @FXML
    private void cancelBtnAction(ActionEvent event) {
        System.out.println("You clicked cancel!");
    }




}
