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

    public SPCluster(String idCluster,String SPCalibration_idSPCalibration){
        this.idCluster = new SimpleStringProperty(idCluster);
        this.SPCalibration_idSPCalibration=new SimpleStringProperty(SPCalibration_idSPCalibration);
        if ( idCluster != null){
            this.idCluster = new SimpleStringProperty(idCluster);
        } else {
            this.idCluster = null;
        }

    }


    public SPCluster(){
        this("","");
    }

    public String getidCluster() {
        if (idCluster == null){
            idCluster = new SimpleStringProperty(null);
        }
        return idCluster.get();
    }


    public void setidCluster(String idCluster) {
        if (this.idCluster == null){
            this.idCluster = new SimpleStringProperty();
        }
        this.idCluster.set(idCluster);
    }

    public StringProperty idClusterProperty() {
        return idCluster;
    }

    public String getSPCalibration_idSPCalibration() {
        return SPCalibration_idSPCalibration.get();
    }

    public StringProperty SPCalibration_idSPCalibrationProperty() {
        return SPCalibration_idSPCalibration;
    }

    public void setSPCalibration_idSPCalibration(String SPCalibration_idSPCalibration) {
        this.SPCalibration_idSPCalibration.set(SPCalibration_idSPCalibration);
    }

    public String toString(){
        return idCluster.getValue()+", " +SPCalibration_idSPCalibration.getValue();
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
