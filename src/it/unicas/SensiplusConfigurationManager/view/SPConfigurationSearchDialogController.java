package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.model.SPConfiguration;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.DAOMySQLSettings;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SPConfigurationSearchDialogController {



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
    @FXML
    private CheckBox idSPConfigurationCheck;
    @FXML
    private CheckBox driverCheck;
    @FXML
    private CheckBox hostControllerCheck;
    @FXML
    private CheckBox apiOwnerCheck;
    @FXML
    private CheckBox mcuCheck;
    @FXML
    private CheckBox protocolCheck;
    @FXML
    private CheckBox addressingTypeCheck;
    @FXML
    private CheckBox idClusterCheck;


    private Stage dialogStage;
    private it.unicas.SensiplusConfigurationManager.model.SPConfiguration SPConfiguration;
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

    public void disableTextboxidSPConfiguration(){
        if (idSPConfigurationCheck.isSelected())
            idSPConfigurationField.setDisable(false);
        else
            idSPConfigurationField.setDisable(true);
    }
    public void disableTextboxdriver(){
        if (driverCheck.isSelected())
            driverField.setDisable(false);
        else
            driverField.setDisable(true);
    }
    public void disableTextboxhostController(){
        if (hostControllerCheck.isSelected())
            hostControllerField.setDisable(false);
        else
            hostControllerField.setDisable(true);
    }
    public void disableTextboxapiOwner(){
        if (apiOwnerCheck.isSelected())
            apiOwnerField.setDisable(false);
        else
            apiOwnerField.setDisable(true);
    }
    public void disableTextboxmcu(){
        if (mcuCheck.isSelected())
            mcuField.setDisable(false);
        else
            mcuField.setDisable(true);
    }
    public void disableTextboxprotocol(){
        if (protocolCheck.isSelected())
            protocolField.setDisable(false);
        else
            protocolField.setDisable(true);
    }
    public void disableTextboxaddressingType(){
        if (addressingTypeCheck.isSelected())
            addressingTypeField.setDisable(false);
        else
            addressingTypeField.setDisable(true);
    }
    public void disableTextboxidCluster(){
        if (idClusterCheck.isSelected())
            idClusterCombobox.setDisable(false);
        else
            idClusterCombobox.setDisable(true);
    }

}
