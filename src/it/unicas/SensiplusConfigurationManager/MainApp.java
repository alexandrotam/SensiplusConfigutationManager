package it.unicas.SensiplusConfigurationManager;

import it.unicas.SensiplusConfigurationManager.model.*;
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
    private ObservableList<SPSensingElementOnChip> SPSensingElementOnChipData = FXCollections.observableArrayList();
    public  ObservableList<SPFamily_has_SPMeasureType> SPFamily_has_SPMeasureTypeData=FXCollections.observableArrayList();


    /**
     * Constructor
     */
    public MainApp() {
    }




   public ObservableList<SPSensingElement> getSPSensingElementData() {return SPSensigElementData;}
    public ObservableList<SPFamily> getSPFamilyData() {return SPFamilyData;}
    public ObservableList<SPSensingelementOnFamily> getSPSensingelementOnFamilyData(){return  SPSensingelementOnFamilyData;}
    public ObservableList<SPChip> getSPChipData() {
        return SPChipData;
    }
    public ObservableList<SPSensingElementOnChip> getSPSensingElementOnChipData() {
        return SPSensingElementOnChipData;
    }
    public ObservableList<SPFamily_has_SPMeasureType> getSPFamily_has_SPMeasureTypeData(){return SPFamily_has_SPMeasureTypeData;}

    @Override
    public void start(Stage primaryStage) {



        this.primaryStage=primaryStage;
        this.primaryStage.setTitle("Sensiplus Configuration Manager");

        this.primaryStage.getIcons().add(new Image("https://previews.123rf.com/images/hedgehogvector/hedgehogvector1603/hedgehogvector160302981/54703708-icona-del-sensore-del-carburante-Archivio-Fotografico.jpg"));

        initRootLayout();
        showHomepageOverview();

        this.primaryStage.show();
        this.primaryStage.setMaximized(true);
        this.primaryStage.setResizable(true);
        this.primaryStage.setMinHeight(480);
        this.primaryStage.setMinWidth(760);

    }

    public void showHomepageOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/HomePage.fxml"));
            AnchorPane HomePageOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(HomePageOverview);

            // Give the controller access to the main app.
            HomePageController controller = loader.getController();
            controller.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public void showSPFamily_has_SPMeasureTypeOverview() {
        try {FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SPFamily_has_SPMeasureTypeOverview.fxml"));
            AnchorPane SPFamily_has_SPMeasureTypeOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(SPFamily_has_SPMeasureTypeOverview);

            // Give the controller access to the main app.
            SPFamily_has_SPMeasureTypeOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showSPChipOverview() {
        try {
            // Load SPCHip overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SPChipOverview.fxml"));
            AnchorPane SPChipOverview = (AnchorPane) loader.load();

            // Set SPChip overview into the center of root layout.
            rootLayout.setCenter(SPChipOverview);

            // Give the controller access to the main app.
            SPChipOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showSPSensingElementOnChipOverview() {
        try {
            // Load SPSensingElementOnChip overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SPSensingElementOnChipOverview.fxml"));
            AnchorPane SPSensingElementOnChipOverview = (AnchorPane) loader.load();

            // Set SPSensingElementOnChip overview into the center of root layout.
            rootLayout.setCenter(SPSensingElementOnChipOverview);

            // Give the controller access to the main app.
            SPSensingElementOnChipOverviewController controller = loader.getController();
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
            dialogStage.setMaximized(true);
            dialogStage.setMinHeight(356);
            dialogStage.setMinWidth(439);
            dialogStage.setResizable(true);

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
            dialogStage.setMaximized(true);
            dialogStage.setMinHeight(724);
            dialogStage.setMinWidth(880);


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
            dialogStage.setMaximized(true);
            dialogStage.setMinWidth(600);
            dialogStage.setMinHeight(400);

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
            dialogStage.setMaximized(true);
            dialogStage.setMinHeight(407);
            dialogStage.setMinWidth(609);

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

    public boolean showSPSensingElementOnChipEditDialog(SPSensingElementOnChip spSensingElementOnChip, boolean verifyLen) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SPSensingElementOnChipEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit SPSensingElementOnChip");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.setMaximized(true);
            dialogStage.setMinWidth(600);
            dialogStage.setMinHeight(400);

            SPSensingElementOnChipEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage, verifyLen);
            controller.setSPSensingElementOnChip(spSensingElementOnChip);

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
            dialogStage.setMaximized(true);
            dialogStage.setMinHeight(400);
            dialogStage.setMinWidth(600);

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
            dialogStage.setMaximized(true);
            dialogStage.setMinHeight(724);
            dialogStage.setMinWidth(880);

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
            dialogStage.setMaximized(true);
            dialogStage.setMinHeight(400);
            dialogStage.setMinWidth(600);

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

    public boolean showSPFamily_has_SPMeasureTypeSearchDialog(SPFamily_has_SPMeasureType spFamily_has_SPMeasureType, boolean verifyLen) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SPFamily_has_SPMeasureTypeSearchDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Search SPFamily_has_SPMeasureType");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.setMaximized(true);
            dialogStage.setMinHeight(400);
            dialogStage.setMinWidth(600);

            SPFamily_has_SPMeasureTypeSearchDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage, verifyLen);
            controller.setSPFamily_has_SPMeasureType(spFamily_has_SPMeasureType);

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
            dialogStage.setMaximized(true);
            dialogStage.setMinHeight(400);
            dialogStage.setMinWidth(600);

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

    public boolean showSPSensingElementOnChipSearchDialog(SPSensingElementOnChip spSensingElementOnChip, boolean verifyLen) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SPSensingElementOnChipSearchDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Search SPSensingElementOnChip");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.setMaximized(true);
            dialogStage.setMinHeight(400);
            dialogStage.setMinWidth(600);

            SPSensingElementOnChipSearchDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage, verifyLen);
            controller.setSPSensingElementOnChip(spSensingElementOnChip);

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
            dialogStage.setMaximized(true);
            dialogStage.setMinHeight(400);
            dialogStage.setMinWidth(600);

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

    public boolean showSPFamily_has_SPMeasureType(SPFamily_has_SPMeasureType spFamily_has_spMeasureType,boolean verifyLen)  {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Measure.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Measure Family");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.getIcons().add(new Image("https://cdn6.aptoide.com/imgs/8/7/5/8756d66a353475d314ee779d6a3d87b7_icon.png?w=240"));
            dialogStage.setMaximized(true);
            dialogStage.setMinHeight(400);
            dialogStage.setMinWidth(600);

            MeasureController controller = loader.getController();
            controller.setDialogStage(dialogStage, verifyLen);
            controller.setSPFamily_has_SPMeasureType(spFamily_has_spMeasureType);

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

