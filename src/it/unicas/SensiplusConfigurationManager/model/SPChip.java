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
    private StringProperty name_family;

    public SPChip(String idSPChip,String name_family){
       this.name_family = new SimpleStringProperty(name_family);

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

    public String getName_family() {
        return name_family.get();
    }

    public StringProperty name_familyProperty() {
        return name_family;
    }

    public void setName_family(String name_family) {
        this.name_family.set(name_family);
    }

    public String toString(){
        return idSPChip.getValue()+", " +name_family.getValue();
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
