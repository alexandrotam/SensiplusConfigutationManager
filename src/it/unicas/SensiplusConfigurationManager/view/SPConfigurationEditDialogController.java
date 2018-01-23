package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.model.SPConfiguration;
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

public class SPConfigurationEditDialogController {


    @FXML
    private TextField idSPConfigurationField;
    @FXML
    private TextField driverField;
    @FXML
    private TextField hostControllerField;
    @FXML
    private TextField apiOwnerField;
    @FXML
    private  TextField mcuField;
    @FXML
    private TextField protocolField;
    @FXML
    private TextField addressingTypeField;
    @FXML
    private ComboBox idClusterCombobox;

    private Stage dialogStage;
    private SPConfiguration SPConfiguration;
    private boolean okClicked = false;
    private boolean verifyLen = true;

    @FXML
    private void initialize() throws SQLException {
        Statement st = DAOMySQLSettings.getStatement();
        ArrayList<String> lista = new ArrayList<>();
        String query="select idCluster from SPCluster";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            lista.add(rs.getString("idCluster"));
        }
        DAOMySQLSettings.closeStatement(st);
        idClusterCombobox.getItems().addAll(lista);
    }

    public void setDialogStage(Stage dialogStage, boolean verifyLen) {
        this.dialogStage = dialogStage;
        this.verifyLen = verifyLen;
        // Set the dialog icon.
    }

    public void setSPConfiguration(SPConfiguration SPConfiguration) {
        this.SPConfiguration = SPConfiguration;
        idSPConfigurationField.setText(SPConfiguration.getidSPConfiguration());
        driverField.setText(SPConfiguration.getDriver());
        hostControllerField.setText(SPConfiguration.getHostController());
        apiOwnerField.setText(SPConfiguration.getApiOwner());
        mcuField.setText(SPConfiguration.getMcu());
        protocolField.setText(SPConfiguration.getProtocol());
        addressingTypeField.setText(SPConfiguration.getAddressingType());
        idClusterCombobox.setValue(SPConfiguration.getIdCluster());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid(verifyLen)) {
            SPConfiguration.setidSPConfiguration(idSPConfigurationField.getText());
            SPConfiguration.setDriver(driverField.getText());
            SPConfiguration.setHostController(hostControllerField.getText());
            SPConfiguration.setApiOwner(apiOwnerField.getText());
            SPConfiguration.setMcu(mcuField.getText());
            SPConfiguration.setProtocol(protocolField.getText());
            SPConfiguration.setAddressingType(addressingTypeField.getText());
            SPConfiguration.setIdCluster(idClusterCombobox.getValue().toString());

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
