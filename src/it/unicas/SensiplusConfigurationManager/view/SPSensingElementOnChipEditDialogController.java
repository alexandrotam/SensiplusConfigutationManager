package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.model.SPSensingElementOnChip;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.DAOMySQLSettings;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static it.unicas.SensiplusConfigurationManager.view.SPSensingElementEditDialogController.isInt;

public class SPSensingElementOnChipEditDialogController {

    @FXML
    private ComboBox idSpChipCombobox;
    @FXML
    private TextField mField;
    @FXML
    private TextField nField;
    @FXML
    private ComboBox nameSPSensingElementOnFamilyCombobox;
    @FXML
    private ComboBox nameCalibrationCombobox;

    private Stage dialogStage;
    private SPSensingElementOnChip SensingElementOnChip;
    private boolean okClicked = false;
    private boolean verifyLen = true;

    @FXML
    private void initialize() throws SQLException {
        Statement st1 = DAOMySQLSettings.getStatement();
        ArrayList<String> lista1 = new ArrayList<>();
        String query1="select idspchip from spchip";
        ResultSet rs1 = st1.executeQuery(query1);
        while(rs1.next()){
            lista1.add(rs1.getString("idSPChip"));
        }
        DAOMySQLSettings.closeStatement(st1);
        idSpChipCombobox.getItems().addAll(lista1);

        Statement st2 = DAOMySQLSettings.getStatement();
        ArrayList<String> lista2 = new ArrayList<>();
        String query2="select name from spsensingelementonfamily";
        ResultSet rs2 = st2.executeQuery(query2);
        while(rs2.next()){
            lista2.add(rs2.getString("name"));
        }
        DAOMySQLSettings.closeStatement(st2);
        nameSPSensingElementOnFamilyCombobox.getItems().addAll(lista2);

        Statement st3 = DAOMySQLSettings.getStatement();
        ArrayList<String> lista3 = new ArrayList<>();
        String query3="select name from spcalibration";
        ResultSet rs3 = st3.executeQuery(query3);

        while(rs3.next()){
            lista3.add(rs3.getString("name"));
        }

        DAOMySQLSettings.closeStatement(st3);
        nameCalibrationCombobox.getItems().addAll(lista3);
        }

    public void setDialogStage(Stage dialogStage, boolean verifyLen) {
        this.dialogStage = dialogStage;
        this.verifyLen = verifyLen;

        // Set the dialog icon.

    }

    public void setSPSensingElementOnChip(SPSensingElementOnChip SensingElementOnChip) {
        this.SensingElementOnChip = SensingElementOnChip;
        idSpChipCombobox.setValue(SensingElementOnChip.getSPChip_idSPChip());
        mField.setText(SensingElementOnChip.getM());
        nField.setText(SensingElementOnChip.getN());
        nameSPSensingElementOnFamilyCombobox.setValue(SensingElementOnChip.getSPSensingElementOnFamily_Name());
        nameCalibrationCombobox.setValue(SensingElementOnChip.getSPCalibration_Name());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid(verifyLen)) {
            SensingElementOnChip.setSPChip_idSPChip(idSpChipCombobox.getValue().toString());
            SensingElementOnChip.setM(mField.getText());
            SensingElementOnChip.setN(nField.getText());
            SensingElementOnChip.setSPSensingElementOnFamily_Name(nameSPSensingElementOnFamilyCombobox.getValue().toString());
            SensingElementOnChip.setSPCalibration_Name(nameCalibrationCombobox.getValue().toString());

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }


    private boolean isInputValid(boolean verifyLen) {
        String errorMessage = "";
        boolean intero;

        if(!mField.getText().equals("DIRECT"))
            if( intero=isInt(mField.getText())==false ||(Double.parseDouble(mField.getText()) < 0.0 || (Double.parseDouble(mField.getText()) > 5000000.0))) {
                errorMessage += "No valid m!\n";
            }
        if(!nField.getText().equals("DIRECT"))
            if( intero=isInt(nField.getText())==false ||(Double.parseDouble(nField.getText()) < 0.0 || (Double.parseDouble(nField.getText()) > 5000000.0))) {
                errorMessage += "No valid n!\n";
            }


        if (errorMessage.length() == 0) {


            return true;

        }else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}



