package it.unicas.SensiplusConfigurationManager.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SPConfiguration {


    private StringProperty idSPConfiguration;
    private StringProperty driver;
    private StringProperty hostController;
    private StringProperty apiOwner;
    private StringProperty mcu;
    private StringProperty protocol;
    private StringProperty addressingType;
    private StringProperty idCluster;



    public SPConfiguration(String idSPConfiguration,String driver, String hostController,String apiOwner,String mcu,
                           String protocol,String addressingType,String idCluster){
        this.idSPConfiguration = new SimpleStringProperty(idSPConfiguration);
        this.driver=new SimpleStringProperty(driver);
        this.hostController=new SimpleStringProperty(hostController);
        this.apiOwner=new SimpleStringProperty(apiOwner);
        this.mcu=new SimpleStringProperty(mcu);
        this.protocol=new SimpleStringProperty(protocol);
        this.addressingType=new SimpleStringProperty(addressingType);
        this.idCluster=new SimpleStringProperty(idCluster);



    }

    public SPConfiguration(StringProperty driver, StringProperty hostController, StringProperty apiOwner, StringProperty mcu, StringProperty protocol, StringProperty addressingType, StringProperty idCluster) {
        this.driver = driver;
        this.hostController = hostController;
        this.apiOwner = apiOwner;
        this.mcu = mcu;
        this.protocol = protocol;
        this.addressingType = addressingType;
        this.idCluster = idCluster;
    }

    public SPConfiguration(){
        this("","","","","","","","");
    }

    public String getidSPConfiguration() {
        if (idSPConfiguration == null){
            idSPConfiguration = new SimpleStringProperty(null);
        }
        return idSPConfiguration.get();
    }


    public void setidSPConfiguration(String idSPConfiguration) {
        if (this.idSPConfiguration == null){
            this.idSPConfiguration = new SimpleStringProperty();
        }
        this.idSPConfiguration.set(idSPConfiguration);
    }

    public StringProperty idSPConfigurationProperty() {
        return idSPConfiguration;
    }

    public String getDriver() {
        return driver.get();
    }

    public StringProperty driverProperty() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver.set(driver);
    }

    public String getHostController() {
        return hostController.get();
    }

    public StringProperty hostControllerProperty() {
        return hostController;
    }

    public void setHostController(String hostController) {
        this.hostController.set(hostController);
    }

    public String getApiOwner() {
        return apiOwner.get();
    }

    public StringProperty apiOwnerProperty() {
        return apiOwner;
    }

    public void setApiOwner(String apiOwner) {
        this.apiOwner.set(apiOwner);
    }

    public String getMcu() {
        return mcu.get();
    }

    public StringProperty mcuProperty() {
        return mcu;
    }

    public void setMcu(String mcu) {
        this.mcu.set(mcu);
    }

    public String getProtocol() {
        return protocol.get();
    }

    public StringProperty protocolProperty() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol.set(protocol);
    }

    public String getAddressingType() {
        return addressingType.get();
    }

    public StringProperty addressingTypeProperty() {
        return addressingType;
    }

    public void setAddressingType(String addressingType) {
        this.addressingType.set(addressingType);
    }

    public String getIdCluster() {
        return idCluster.get();
    }

    public StringProperty idClusterProperty() {
        return idCluster;
    }

    public void setIdCluster(String idCluster) {
        this.idCluster.set(idCluster);
    }

    public String toString(){
        return idSPConfiguration.getValue()+", " +driver.getValue()+", "+hostController.getValue()+", "+apiOwner.getValue()
                +", "+mcu.getValue()+", "+protocol.getValue()+", "+addressingType.getValue()+", "+idCluster.getValue();
    }


    public static void main(String[] args) {
        SPConfiguration spConfiguration = new SPConfiguration();


        // Use Java Collections to create the List.
        List<SPConfiguration> list = new ArrayList<>();

        // Now add observability by wrapping it with ObservableList.
        ObservableList<SPConfiguration> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener() {

            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Detected a change! ");
            }
        });

        System.out.println("Size: "+observableList.size());
    }

}
