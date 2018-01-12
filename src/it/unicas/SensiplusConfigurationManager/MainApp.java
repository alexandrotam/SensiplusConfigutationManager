package it.unicas.SensiplusConfigurationManager;

import it.unicas.SensiplusConfigurationManager.model.SPChip;
import it.unicas.SensiplusConfigurationManager.model.SPFamily;
import it.unicas.SensiplusConfigurationManager.model.SPSensingElement;
import it.unicas.SensiplusConfigurationManager.model.SPSensingelementOnFamily;
import it.unicas.SensiplusConfigurationManager.model.dao.mysql.DAOMySQLSettings;
import it.unicas.SensiplusConfigurationManager.view.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;



public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    /**
     * The data as an observable list of spSensingElement.
     */
    private ObservableList<SPSensingElement> SPSensigElementData = FXCollections.observableArrayList();
    private ObservableList<SPFamily> SPFamilyData = FXCollections.observableArrayList();
    private ObservableList<SPSensingelementOnFamily> SPSensingelementOnFamilyData = FXCollections.observableArrayList();
    private ObservableList<SPChip> SPChipData = FXCollections.observableArrayList();


    /**
     * Constructor
     */
    public MainApp() {
    }




   public ObservableList<SPSensingElement> getSPSensingElementData() {
        return SPSensigElementData;
    }
    public ObservableList<SPFamily> getSPFamilyData() {
        return SPFamilyData;
    }

    public ObservableList<SPSensingelementOnFamily> getSPSensingelementOnFamilyData(){
        return  SPSensingelementOnFamilyData;
    }

    public ObservableList<SPChip> getSPChipData() {
        return SPChipData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage=primaryStage;
        this.primaryStage.setTitle("Sensiplus Configuration Manager");

        this.primaryStage.getIcons().add(new Image("https://previews.123rf.com/images/hedgehogvector/hedgehogvector1603/hedgehogvector160302981/54703708-icona-del-sensore-del-carburante-Archivio-Fotografico.jpg"));

        initRootLayout();
        showSPSensingElementOverview();
        this.primaryStage.show();
    }

    public void showSPSensingElementOverview() {
        try {
            // Load SPSensingElement overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SPSensingElementOverview.fxml"));
            AnchorPane SPSensingElementOverview = (AnchorPane) loader.load();

            // Set SPSensingElement overview into the center of root layout.
            rootLayout.setCenter(SPSensingElementOverview);

            // Give the controller access to the main app.
            SPSensingElementOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showSPFamilyOverview() {
        try {
            // Load SPFamily overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SPFamilyOverview.fxml"));
            AnchorPane SPFamilyOverview = (AnchorPane) loader.load();

            // Set SPFamily overview into the center of root layout.
            rootLayout.setCenter(SPFamilyOverview);

            // Give the controller access to the main app.
            SPFamilyOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showSPSensingelementOnFamilyOverview() {
        try {
            // Load SPSensingelementOnFamily overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SPSensingElementOnFamilyOverview.fxml"));
            AnchorPane SPSensingelementOnFamilyOverview = (AnchorPane) loader.load();

            // Set SPSensingelementOnFamily overview into the center of root layout.
            rootLayout.setCenter(SPSensingelementOnFamilyOverview);

            // Give the controller access to the main app.
            SPSensingElementOnFamilyOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showSPChipOverview() {
        try {
            // Load SPFamily overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SPChipOverview.fxml"));
            AnchorPane SPChipOverview = (AnchorPane) loader.load();

            // Set SPFamily overview into the center of root layout.
            rootLayout.setCenter(SPChipOverview);

            // Give the controller access to the main app.
            SPChipOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            primaryStage.setOnCloseRequest(event -> {
                event.consume();
                handleExit();
            });


            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void handleExit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Are you sure?");
        alert.setHeaderText("Exit");
        alert.setContentText("Exit from application.");

        ButtonType buttonTypeOne = new ButtonType("Yes");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            System.exit(0);
        }

    }


    public boolean showSettingsEditDialog(DAOMySQLSettings daoMySQLSettings){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SettingsEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("DAOSPSensingElement settings");
            dialogStage.initModality((Modality.WINDOW_MODAL));
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);



            SettingsEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setSettings(daoMySQLSettings);


            dialogStage.showAndWait();


            return controller.isOkClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showSPSensingElementEditDialog(SPSensingElement spSensingElement, boolean verifyLen) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SPSensingELementEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit SPSensingELement");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.getIcons().add(new Image("https://cdn6.aptoide.com/imgs/8/7/5/8756d66a353475d314ee779d6a3d87b7_icon.png?w=240"));

            SPSensingElementEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage, verifyLen);
            controller.setSPSensingElement(spSensingElement);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showSPFamilyEditDialog(SPFamily spFamily, boolean verifyLen) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SPFamilyEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit SPFamily");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            SPFamilyEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage, verifyLen);
            controller.setSPFamily(spFamily);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

   public boolean showSPChipEditDialog(SPChip spChip, boolean verifyLen) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SPChipEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit SPChip");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            SPChipEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage, verifyLen);
            controller.setSPChip(spChip);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showSPFamilySearchDialog(SPFamily spFamily, boolean verifyLen) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SPFamilySearchDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Search SPFamily");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            SPFamilySearchDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage, verifyLen);
            controller.setSPFamily(spFamily);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showSPSensingElementSearchDialog(SPSensingElement spSensingElement, boolean verifyLen) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SPSensingELementSearchDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Search SPSensingELement");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            SPSensingElementSearchDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage, verifyLen);
            controller.setSPSensingElement(spSensingElement);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showSPSensingelementOnFamilySearchDialog(SPSensingelementOnFamily spSensingelementOnFamily, boolean verifyLen) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SPSensingElementOnFamilySearchDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Search SPSensingelementOnFamily");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            SPSensingElementOnFamiySearchDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage, verifyLen);
            controller.setSPSensingelementOnFamily(spSensingelementOnFamily);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showSPChipSearchDialog(SPChip spChip, boolean verifyLen) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SPChipSearchDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Search SPChip");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            SPChipSearchDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage, verifyLen);
            controller.setSPChip(spChip);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showGenerateFamily(SPSensingelementOnFamily spSensingelementOnFamily,boolean verifyLen)  {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/GenerateFamily.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Generate Family");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.getIcons().add(new Image("https://cdn6.aptoide.com/imgs/8/7/5/8756d66a353475d314ee779d6a3d87b7_icon.png?w=240"));

            GenerateFamilyController controller = loader.getController();
            controller.setDialogStage(dialogStage, verifyLen);
            controller.setSPSensingElementOnFamily(spSensingelementOnFamily);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);

    }

}

