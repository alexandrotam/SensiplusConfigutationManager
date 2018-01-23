package it.unicas.SensiplusConfigurationManager.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SPCluster {


    private StringProperty idCluster;
    private StringProperty SPCalibration_idSPCalibration;
    private StringProperty SPCalibration_NameSPCalibration;

    public SPCluster(String idCluster,String SPCalibration_NameSPCalibration){
        this.idCluster = new SimpleStringProperty(idCluster);
        this.SPCalibration_NameSPCalibration=new SimpleStringProperty(SPCalibration_NameSPCalibration);
    }


    public SPCluster(){
        this("","");
    }

    public String getIdCluster() {return idCluster.get();}

    public StringProperty idClusterProperty() {
        return idCluster;
    }

    public void setIdCluster(String idCluster) {
        this.idCluster.set(idCluster);
    }

    public String getSPCalibration_idSPCalibration() {
        if( SPCalibration_idSPCalibration == null)
            SPCalibration_idSPCalibration = new SimpleStringProperty("");
        return SPCalibration_idSPCalibration.get();
    }

    public StringProperty SPCalibration_idSPCalibrationProperty() {
        return SPCalibration_idSPCalibration;
    }

    public void setSPCalibration_idSPCalibration(String SPCalibration_idSPCalibration) {
        if(this.SPCalibration_idSPCalibration == null)
            this.SPCalibration_idSPCalibration = new SimpleStringProperty();
        this.SPCalibration_idSPCalibration.set(SPCalibration_idSPCalibration);
    }

    public String getSPCalibration_NameSPCalibration() {
        return SPCalibration_NameSPCalibration.get();
    }

    public StringProperty SPCalibration_NameSPCalibrationProperty() {
        return SPCalibration_NameSPCalibration;
    }

    public void setSPCalibration_NameSPCalibration(String SPCalibration_NameSPCalibration) {
        this.SPCalibration_NameSPCalibration.set(SPCalibration_NameSPCalibration);
    }

    public String toString(){
        return idCluster.getValue()+", " +SPCalibration_NameSPCalibration.getValue();
    }


    public static void main(String[] args) {
        SPCluster spCluster = new SPCluster();


        // Use Java Collections to create the List.
        List<SPCluster> list = new ArrayList<>();

        // Now add observability by wrapping it with ObservableList.
        ObservableList<SPCluster> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener() {

            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Detected a change! ");
            }
        });

        System.out.println("Size: "+observableList.size());
    }
}
