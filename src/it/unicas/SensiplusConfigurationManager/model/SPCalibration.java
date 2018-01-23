package it.unicas.SensiplusConfigurationManager.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SPCalibration {



    private StringProperty idSPCalibration;
    private StringProperty name;

    public SPCalibration(String idSPCalibration,String name){
        this.idSPCalibration = new SimpleStringProperty(idSPCalibration);
        this.name=new SimpleStringProperty(name);
        if ( idSPCalibration != null){
            this.idSPCalibration = new SimpleStringProperty(idSPCalibration);
        } else {
            this.idSPCalibration = null;
        }

    }


    public SPCalibration(){
        this("","");
    }

    public String getidSPCalibration() {
        if (idSPCalibration == null){
            idSPCalibration = new SimpleStringProperty(null);
        }
        return idSPCalibration.get();
    }


    public void setidSPCalibration(String idSPCalibration) {
        if (this.idSPCalibration == null){
            this.idSPCalibration = new SimpleStringProperty();
        }
        this.idSPCalibration.set(idSPCalibration);
    }

    public StringProperty idSPCalibrationProperty() {
        return idSPCalibration;
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
        return idSPCalibration.getValue()+", " +name.getValue();
    }


    public static void main(String[] args) {
        SPCalibration spCalibration = new SPCalibration();


        // Use Java Collections to create the List.
        List<SPCalibration> list = new ArrayList<>();

        // Now add observability by wrapping it with ObservableList.
        ObservableList<SPCalibration> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener() {

            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Detected a change! ");
            }
        });

        System.out.println("Size: "+observableList.size());
    }
}
