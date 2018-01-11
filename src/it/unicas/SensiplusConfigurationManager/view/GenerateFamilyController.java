package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.model.SPSensingelementOnFamily;
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


public class GenerateFamilyController {

    @FXML
    private ComboBox idSPSensingElementCombobox;
    @FXML
    private ComboBox idSPFamilyCombobox;
    @FXML
    private ComboBox idSPPortCombobox;
    @FXML
    private TextField nameField;



    private Stage dialogStage;
    private SPSensingelementOnFamily SensingElementOnFamily;
    private boolean okClicked = false;
    private boolean verifyLen = true;


    @FXML
    private void initialize() throws SQLException {
        Statement st1 = DAOMySQLSettings.getStatement();
        ArrayList<String> lista1 = new ArrayList<>();
        String query1="select idSPSensingElement from spsensingelement";
       ResultSet rs1 = st1.executeQuery(query1);
       while(rs1.next()){
            lista1.add(rs1.getString("idSPSensingElement"));
        }
        DAOMySQLSettings.closeStatement(st1);
        idSPSensingElementCombobox.getItems().addAll(lista1);

        Statement st2 = DAOMySQLSettings.getStatement();
        ArrayList<String> lista2 = new ArrayList<>();
        String query2="select idSPFamily from spfamily";
        ResultSet rs2 = st2.executeQuery(query2);
        while(rs2.next()){
            lista2.add(rs2.getString("idSPFamily"));
        }
        DAOMySQLSettings.closeStatement(st2);
        idSPFamilyCombobox.getItems().addAll(lista2);

        Statement st3 = DAOMySQLSettings.getStatement();
        ArrayList<String> lista3 = new ArrayList<>();
        String query3="select idSPPort from spport";
        ResultSet rs3 = st3.executeQuery(query3);
        while(rs3.next()){
            lista3.add(rs3.getString("idSPPort"));
        }
        DAOMySQLSettings.closeStatement(st3);
        idSPPortCombobox.getItems().addAll(lista3);

    }

    public void setDialogStage(Stage dialogStage, boolean verifyLen) {
        this.dialogStage = dialogStage;
        this.verifyLen = verifyLen;

        // Set the dialog icon.

    }

    public void setSPSensingElementOnFamily(SPSensingelementOnFamily SensingElementOnFamily) {
        this.SensingElementOnFamily = SensingElementOnFamily;
        nameField.setText(SensingElementOnFamily.getName());
        idSPSensingElementCombobox.setValue(SensingElementOnFamily.getSPSensingElement_idSPSensingElement());
        idSPFamilyCombobox.setValue(SensingElementOnFamily.getSPFamily_idSPFamily());
        idSPPortCombobox.setValue(SensingElementOnFamily.getSPPort_idSPPort());


    }



    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid(verifyLen)) {
            SensingElementOnFamily.setName(nameField.getText());
            SensingElementOnFamily.setSPSensingElement_idSPSensingElement(idSPSensingElementCombobox.getValue().toString());
            SensingElementOnFamily.setSPFamily_idSPFamily(idSPFamilyCombobox.getValue().toString());
            SensingElementOnFamily.setSPPort_idSPPort(idSPPortCombobox.getValue().toString());

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
