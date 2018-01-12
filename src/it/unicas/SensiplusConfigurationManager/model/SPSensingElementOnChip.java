package it.unicas.SensiplusConfigurationManager.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SPSensingElementOnChip {


    private StringProperty SPChip_idSPChip;
    private StringProperty m;
    private StringProperty n;
    private StringProperty SPSensingElementOnFamily_idSPSensingElementOnFamily;
    private StringProperty SPCalibration_idSPCalibration;


    public SPSensingElementOnChip(String SPChip_idSPChip,String m,String n,
                                  String SPSensingElementOnFamily_idSPSensingElementOnFamily,
                                  String SPCalibration_idSPCalibration){
        this.m = new SimpleStringProperty(m);
        this.n = new SimpleStringProperty(n);
        this.SPSensingElementOnFamily_idSPSensingElementOnFamily = new SimpleStringProperty(SPSensingElementOnFamily_idSPSensingElementOnFamily);
        this.SPCalibration_idSPCalibration = new SimpleStringProperty(SPCalibration_idSPCalibration);
        this.SPChip_idSPChip = new SimpleStringProperty(SPChip_idSPChip);


    }


    public SPSensingElementOnChip(){ this("","","","","");
    }

    public String getSPChip_idSPChip() {
        return SPChip_idSPChip.get();
    }

    public StringProperty SPChip_idSPChipProperty() {
        return SPChip_idSPChip;
    }

    public void setSPChip_idSPChip(String SPChip_idSPChip) {
        this.SPChip_idSPChip.set(SPChip_idSPChip);
    }

    public String getM() {
        return m.get();
    }

    public StringProperty mProperty() {
        return m;
    }

    public void setM(String m) {
        this.m.set(m);
    }

    public String getN() {
        return n.get();
    }

    public StringProperty nProperty() {
        return n;
    }

    public void setN(String n) {
        this.n.set(n);
    }

    public String getSPSensingElementOnFamily_idSPSensingElementOnFamily() {
        return SPSensingElementOnFamily_idSPSensingElementOnFamily.get();
    }

    public StringProperty SPSensingElementOnFamily_idSPSensingElementOnFamilyProperty() {
        return SPSensingElementOnFamily_idSPSensingElementOnFamily;
    }

    public void setSPSensingElementOnFamily_idSPSensingElementOnFamily(String SPSensingElementOnFamily_idSPSensingElementOnFamily) {
        this.SPSensingElementOnFamily_idSPSensingElementOnFamily.set(SPSensingElementOnFamily_idSPSensingElementOnFamily);
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
        return SPChip_idSPChip.getValue()+", " +m.getValue()+", "+n.getValue()+
                ", "+SPSensingElementOnFamily_idSPSensingElementOnFamily.getValue()+
                ", "+SPCalibration_idSPCalibration.getValue();
    }


    public static void main(String[] args) {
        SPSensingElementOnChip spSensingElementOnChip = new SPSensingElementOnChip();


        // Use Java Collections to create the List.
        List<SPSensingElementOnChip> list = new ArrayList<>();

        // Now add observability by wrapping it with ObservableList.
        ObservableList<SPSensingElementOnChip> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener() {

            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Detected a change! ");
            }
        });

        System.out.println("Size: "+observableList.size());
    }

}
