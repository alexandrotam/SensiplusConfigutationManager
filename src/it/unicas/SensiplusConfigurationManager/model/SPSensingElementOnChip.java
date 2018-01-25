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
    private StringProperty SPSensingElementOnFamily_Name;
    private StringProperty SPCalibration_Name;


    public SPSensingElementOnChip(String SPChip_idSPChip,String m,String n,
                                   String SPSensingElementOnFamily_Name,
                                  String SPCalibration_Name){
        this.m = new SimpleStringProperty(m);
        this.n = new SimpleStringProperty(n);
        this.SPChip_idSPChip = new SimpleStringProperty(SPChip_idSPChip);
        this.SPSensingElementOnFamily_Name = new SimpleStringProperty(SPSensingElementOnFamily_Name);
        this.SPCalibration_Name = new SimpleStringProperty(SPCalibration_Name);

    }


    public SPSensingElementOnChip(){ this("","","","",
            "");
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

    public String getSPSensingElementOnFamily_Name() {
        return SPSensingElementOnFamily_Name.get();
    }

    public StringProperty SPSensingElementOnFamily_NameProperty() {
        return SPSensingElementOnFamily_Name;
    }

    public void setSPSensingElementOnFamily_Name(String SPSensingElementOnFamily_Name) {
        this.SPSensingElementOnFamily_Name.set(SPSensingElementOnFamily_Name);
    }

    public String getSPCalibration_Name() {
        return SPCalibration_Name.get();
    }

    public StringProperty SPCalibration_NameProperty() {
        return SPCalibration_Name;
    }

    public void setSPCalibration_Name(String SPCalibration_Name) {
        this.SPCalibration_Name.set(SPCalibration_Name);
    }


    public String toString(){
        return SPChip_idSPChip.getValue()+", " +m.getValue()+", "+n.getValue()+
                ", "+SPSensingElementOnFamily_Name.getValue()+
                ", "+SPCalibration_Name.getValue();
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
