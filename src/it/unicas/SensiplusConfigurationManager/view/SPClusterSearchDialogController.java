package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.model.SPCluster;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.DAOMySQLSettings;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SPClusterSearchDialogController {

    @FXML
    private TextField idSPClusterField;
    @FXML
    private ComboBox Name_SPCalibrationCombobox;
    @FXML
    private CheckBox idSPClusterCheck;
    @FXML
    private CheckBox Name_SPCalibrationCheck;

    private Stage dialogStage;
    private it.unicas.SensiplusConfigurationManager.model.SPCluster SPCluster;
    private boolean okClicked = false;
    private boolean verifyLen = true;

    @FXML
    private void initialize() throws SQLException {
        Statement st = DAOMySQLSettings.getStatement();
        ArrayList<String> lista = new ArrayList<>();
        String query="select name from spcalibration";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            lista.add(rs.getString("name"));
        }
        DAOMySQLSettings.closeStatement(st);
        Name_SPCalibrationCombobox.getItems().addAll(lista);
    }

    public void setDialogStage(Stage dialogStage, boolean verifyLen) {
        this.dialogStage = dialogStage;
        this.verifyLen = verifyLen;
        // Set the dialog icon.
    }

    public void setSPCluster(SPCluster SPCluster) {
        this.SPCluster = SPCluster;
        idSPClusterField.setText(SPCluster.getIdCluster());
        Name_SPCalibrationCombobox.setValue(SPCluster.getSPCalibration_NameSPCalibration());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid(verifyLen)) {
            SPCluster.setIdCluster(idSPClusterField.getText());
            SPCluster.setSPCalibration_NameSPCalibration(Name_SPCalibrationCombobox.getValue().toString());

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    public void disableTextboxidSPCluster(){
        if (idSPClusterCheck.isSelected())
            idSPClusterField.setDisable(false);
        else
            idSPClusterField.setDisable(true);

    }

    public void disableTextboxNameSPCalibration(){
        if (Name_SPCalibrationCheck.isSelected())
            Name_SPCalibrationCombobox.setDisable(false);
        else
            Name_SPCalibrationCombobox.setDisable(true);
    }

    private boolean isInputValid(boolean verifyLen) {
        String errorMessage = "";

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
