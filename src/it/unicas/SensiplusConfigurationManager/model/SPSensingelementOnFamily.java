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
    private StringProperty SPFamilyTemplate_idSPFamilyTemplate;
    private StringProperty name;


    public SPSensingelementOnFamily(String idSPSensingElementOnFamily,String SPSensingElement_idSPSensingElement,
                                    String SPFamilyTemplate_idSPFamilyTemplate,String name) {
        this.SPSensingElement_idSPSensingElement=new SimpleStringProperty(SPSensingElement_idSPSensingElement);
        this.SPFamilyTemplate_idSPFamilyTemplate=new SimpleStringProperty(SPFamilyTemplate_idSPFamilyTemplate);
        this.name = new SimpleStringProperty(name);

        if ( idSPSensingElementOnFamily != null){
            this.idSPSensingElementOnFamily = new SimpleStringProperty(idSPSensingElementOnFamily);
        } else {
            this.idSPSensingElementOnFamily = null;
        }

    }


    public SPSensingelementOnFamily (String idSPSensingElementOnFamily){
        this.idSPSensingElementOnFamily= new SimpleStringProperty(idSPSensingElementOnFamily);
        this.SPSensingElement_idSPSensingElement = new SimpleStringProperty("");
        this.SPFamilyTemplate_idSPFamilyTemplate = new SimpleStringProperty("");
        this.name = new SimpleStringProperty("");

    }


    public SPSensingelementOnFamily() {
        this(null,null,null,null);
    }

    public SPSensingelementOnFamily(String idSPSensingElementOnFamily, String name) {
        this.idSPSensingElementOnFamily = new SimpleStringProperty(idSPSensingElementOnFamily);
        this.name=new SimpleStringProperty(name);

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

    public String getSPFamilyTemplate_idSPFamilyTemplate() {
        return SPFamilyTemplate_idSPFamilyTemplate.get();
    }

    public StringProperty SPFamilyTemplate_idSPFamilyTemplateProperty() {
        return SPFamilyTemplate_idSPFamilyTemplate;
    }

    public void setSPFamilyTemplate_idSPFamilyTemplate(String SPFamilyTemplate_idSPFamilyTemplate) {
        this.SPFamilyTemplate_idSPFamilyTemplate.set(SPFamilyTemplate_idSPFamilyTemplate);
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

    public String toString(){
        return name.getValue()+", " +SPSensingElement_idSPSensingElement.getValue()+", "+ SPFamilyTemplate_idSPFamilyTemplate.getValue()+", "+
                idSPSensingElementOnFamily.getValue();
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
