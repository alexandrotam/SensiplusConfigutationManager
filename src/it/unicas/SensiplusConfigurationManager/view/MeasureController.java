package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.model.SPFamily_has_SPMeasureType;
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

public class MeasureController {


    @FXML
    private ComboBox Name_Measure_TypeCombobox;
    @FXML
    private ComboBox Name_FamilyCombobox;



    private Stage dialogStage;
    private SPFamily_has_SPMeasureType Family_has_SPMeasureType ;
    private boolean okClicked = false;
    private boolean verifyLen = true;


    @FXML
    private void initialize() throws SQLException {
        Statement st1 = DAOMySQLSettings.getStatement();
        ArrayList<String> lista1 = new ArrayList<>();
        String query1="select name from SPFamily";
        ResultSet rs1 = st1.executeQuery(query1);
        while(rs1.next()){
            lista1.add(rs1.getString("name"));
        }
        DAOMySQLSettings.closeStatement(st1);
        Name_FamilyCombobox.getItems().addAll(lista1);

        Statement st2 = DAOMySQLSettings.getStatement();
        ArrayList<String> lista2 = new ArrayList<>();
        String query2="select type from SPMeasureTechniques";
        ResultSet rs2 = st2.executeQuery(query2);
        while(rs2.next()){
            lista2.add(rs2.getString("type"));
        }
        DAOMySQLSettings.closeStatement(st2);
        Name_Measure_TypeCombobox.getItems().addAll(lista2);
    }

    public void setDialogStage(Stage dialogStage, boolean verifyLen) {
        this.dialogStage = dialogStage;
        this.verifyLen = verifyLen;

        // Set the dialog icon.

    }

    public void setSPFamily_has_SPMeasureType(SPFamily_has_SPMeasureType Family_has_SPMeasureType) {
        this.Family_has_SPMeasureType = Family_has_SPMeasureType;
        Name_Measure_TypeCombobox.setValue(Family_has_SPMeasureType.getName_Measure_Type());
        Name_FamilyCombobox.setValue(Family_has_SPMeasureType.getName_Family());


    }



    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid(verifyLen)) {
            Family_has_SPMeasureType.setName_Measure_Type(Name_Measure_TypeCombobox.getValue().toString());
            Family_has_SPMeasureType.setName_Family(Name_FamilyCombobox.getValue().toString());

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
