package it.unicas.SensiplusConfigurationManager.view;

import it.unicas.SensiplusConfigurationManager.MainApp;
import it.unicas.SensiplusConfigurationManager.model.SPFamily;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.SPFamilyDAOMySQLImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.List;

public class SPFamilyOverviewController {
    @FXML
    private TableView<SPFamily> spFamilyTableView;
    @FXML
    private TableColumn<SPFamily, String> idSPFamilyColumn;
    @FXML
    private TableColumn<SPFamily, String> nameColumn;
    @FXML
    private TableColumn<SPFamily, String> idColumn;
    @FXML
    private TableColumn<SPFamily, String> hwVersionColumn;
    @FXML
    private TableColumn<SPFamily, String> sysclockColumn;
    @FXML
    private TableColumn<SPFamily, String> osctrimColumn;

    @FXML
    private Label idSPFamilyLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label hwVersionLabel;
    @FXML
    private Label sysclockLabel;
    @FXML
    private Label osctrimLabel;

    public MainApp mainApp;

    public SPFamilyOverviewController() {
    }

    /*

*/
}

