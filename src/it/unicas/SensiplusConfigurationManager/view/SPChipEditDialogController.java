package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.model.SPChip;
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

public class SPChipEditDialogController {

    @FXML
    private TextField idSPChipField;
    @FXML
    private ComboBox namefamilyCombobox;

    private Stage dialogStage;
    private SPChip SPChip;
    private boolean okClicked = false;
    private boolean verifyLen = true;

    @FXML
    private void initialize() throws SQLException {
        Statement st = DAOMySQLSettings.getStatement();
        ArrayList<String> lista = new ArrayList<>();
        String query="select name from spfamily";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            lista.add(rs.getString("name"));
        }
        DAOMySQLSettings.closeStatement(st);
        namefamilyCombobox.getItems().addAll(lista);
    }

    public void setDialogStage(Stage dialogStage, boolean verifyLen) {
        this.dialogStage = dialogStage;
        this.verifyLen = verifyLen;
        // Set the dialog icon.
    }

    public void setSPChip(SPChip SPChip) {
        this.SPChip = SPChip;
        idSPChipField.setText(SPChip.getidSPChip());
        namefamilyCombobox.setValue(SPChip.getName_family());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid(verifyLen)) {
            SPChip.setidSPChip(idSPChipField.getText());
            SPChip.setName_family(namefamilyCombobox.getValue().toString());

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
