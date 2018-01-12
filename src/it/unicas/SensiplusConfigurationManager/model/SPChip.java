package it.unicas.SensiplusConfigurationManager.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SPChip {

    private StringProperty idSPChip;
    private StringProperty SPFamily_idSPFamily;

    public SPChip(String idSPChip,String SPFamily_idSPFamily){
       this.SPFamily_idSPFamily = new SimpleStringProperty(SPFamily_idSPFamily);

        if ( idSPChip != null){
            this.idSPChip = new SimpleStringProperty(idSPChip);
        } else {
            this.idSPChip = null;
        }

    }


    public SPChip(){
        this("","");
    }

    public String getidSPChip() {
        if (idSPChip == null){
            idSPChip = new SimpleStringProperty(null);
        }
        return idSPChip.get();
    }


    public void setidSPChip(String idSPChip) {
        if (this.idSPChip == null){
            this.idSPChip = new SimpleStringProperty();
        }
        this.idSPChip.set(idSPChip);
    }

    public StringProperty idSPChipProperty() {
        return idSPChip;
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

    public String toString(){
        return idSPChip.getValue()+", " +SPFamily_idSPFamily.getValue();
    }


    public static void main(String[] args) {
        SPChip spChip = new SPChip();


        // Use Java Collections to create the List.
        List<SPChip> list = new ArrayList<>();

        // Now add observability by wrapping it with ObservableList.
        ObservableList<SPChip> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener() {

            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Detected a change! ");
            }
        });

        System.out.println("Size: "+observableList.size());
    }

}
