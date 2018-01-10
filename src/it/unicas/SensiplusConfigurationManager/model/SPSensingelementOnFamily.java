package it.unicas.SensiplusConfigurationManager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SPSensingelementOnFamily {


    private StringProperty idSPSensingElementOnFamily;
    private StringProperty SPSensingElement_idSPSensingElement;
    private StringProperty name;
    private StringProperty SPFamily_idSPFamily;
    private StringProperty SPPort_idSPPort;


    public SPSensingelementOnFamily(String idSPSensingElementOnFamily,String SPSensingElement_idSPSensingElement
                                    ,String name, String SPFamily_idSPFamily,
                                    String SPPort_idSPPort) {
        this.SPSensingElement_idSPSensingElement=new SimpleStringProperty(SPSensingElement_idSPSensingElement);
        this.name = new SimpleStringProperty(name);
        this.SPFamily_idSPFamily=new SimpleStringProperty(SPFamily_idSPFamily);
        this.SPPort_idSPPort=new SimpleStringProperty(SPPort_idSPPort);

        if ( idSPSensingElementOnFamily != null){
            this.idSPSensingElementOnFamily = new SimpleStringProperty(idSPSensingElementOnFamily);
        } else {
            this.idSPSensingElementOnFamily = null;
        }


    }


    public SPSensingelementOnFamily() {
        this("","","","","");
    }

    public SPSensingelementOnFamily(String spSensingElement_idSPSensingElement, String spFamily_idSPFamily, String spPort_idSPPort, String name) {
        this.SPSensingElement_idSPSensingElement=new SimpleStringProperty(spSensingElement_idSPSensingElement);
        this.name = new SimpleStringProperty(name);
        this.SPFamily_idSPFamily=new SimpleStringProperty(spFamily_idSPFamily);
        this.SPPort_idSPPort=new SimpleStringProperty(spPort_idSPPort);


    }


    public StringProperty idSPSensingElementOnFamilyProperty() {
        return idSPSensingElementOnFamily;
    }


    public String getidSPSensingElementOnFamily() {
        if (idSPSensingElementOnFamily == null){
            idSPSensingElementOnFamily = new SimpleStringProperty("");
        }
        return idSPSensingElementOnFamily.get();
    }


    public void setidSPSensingElementOnFamily(String idSPFamily) {
        if (this.idSPSensingElementOnFamily == null){
            this.idSPSensingElementOnFamily = new SimpleStringProperty();
        }
        this.idSPSensingElementOnFamily.set(idSPFamily);
    }

    public String getSPSensingElement_idSPSensingElement() {
        return SPSensingElement_idSPSensingElement.get();
    }

    public StringProperty SPSensingElement_idSPSensingElementProperty() {
        return SPSensingElement_idSPSensingElement;
    }

    public void setSPSensingElement_idSPSensingElement(String SPSensingElement_idSPSensingElement) {
        this.SPSensingElement_idSPSensingElement.set(SPSensingElement_idSPSensingElement);
    }

    public String getName() {

        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSPFamily_idSPFamily() {

        return SPFamily_idSPFamily.get();
    }

    public StringProperty SPFamily_idSPFamilyProperty() {
        return SPFamily_idSPFamily;
    }

    public void setSPFamily_idSPFamily(String SPFamily_idSPFamily) {
        this.SPFamily_idSPFamily.set(SPFamily_idSPFamily);
    }

    public String getSPPort_idSPPort() {

        return SPPort_idSPPort.get();
    }

    public StringProperty SPPort_idSPPortProperty() {
        return SPPort_idSPPort;
    }

    public void setSPPort_idSPPort(String SPPort_idSPPort) {
        this.SPPort_idSPPort.set(SPPort_idSPPort);
    }

    public String toString(){
        return name.getValue()+", " +SPSensingElement_idSPSensingElement.getValue()+", "+ idSPSensingElementOnFamily.getValue()
                +", "+SPFamily_idSPFamily.getValue()+", "+SPPort_idSPPort.getValue();
    }


    public static void main(String[] args) {
        SPSensingelementOnFamily spSensingelementOnFamily = new SPSensingelementOnFamily();


        // Use Java Collections to create the List.
        List<SPSensingelementOnFamily> list = new ArrayList<>();

        // Now add observability by wrapping it with ObservableList.
        ObservableList<SPSensingelementOnFamily> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener() {

            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Detected a change! ");
            }
        });

        System.out.println("Size: "+observableList.size());
    }
}
