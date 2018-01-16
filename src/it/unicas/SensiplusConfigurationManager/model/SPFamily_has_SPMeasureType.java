package it.unicas.SensiplusConfigurationManager.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SPFamily_has_SPMeasureType {

    private StringProperty SPFamily_idSPFamily;
      private StringProperty Name_Family;
    private StringProperty SPMeasureType_idSPMeasureType;
    private StringProperty Name_Measure_Type;

    public SPFamily_has_SPMeasureType(String SPMeasureType_idSPMeasureType,String Name_Measure_Type,String SPFamily_idSPFamily,
                                      String Name_Family     ){
        this.SPFamily_idSPFamily = new SimpleStringProperty(SPFamily_idSPFamily);
        this.SPMeasureType_idSPMeasureType=new SimpleStringProperty(SPMeasureType_idSPMeasureType);
        this.Name_Family=new SimpleStringProperty(Name_Family);
        this.Name_Measure_Type=new SimpleStringProperty(Name_Measure_Type);


    }

    public SPFamily_has_SPMeasureType(){
        this("","","","");
    }

    public String getSPMeasureType_idSPMeasureType() {
        return SPMeasureType_idSPMeasureType.get();
    }

    public StringProperty SPMeasureType_idSPMeasureTypeProperty() {
        return SPMeasureType_idSPMeasureType;
    }

    public void setSPMeasureType_idSPMeasureType(String SPMeasureType_idSPMeasureType) {
        this.SPMeasureType_idSPMeasureType.set(SPMeasureType_idSPMeasureType);
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

    public String getName_Family() {
        return Name_Family.get();
    }

    public StringProperty name_FamilyProperty() {
        return Name_Family;
    }

    public void setName_Family(String name_Family) {
        this.Name_Family.set(name_Family);
    }

    public String getName_Measure_Type() {
        return Name_Measure_Type.get();
    }

    public StringProperty name_Measure_TypeProperty() {
        return Name_Measure_Type;
    }

    public void setName_Measure_Type(String name_Measure_Type) {
        this.Name_Measure_Type.set(name_Measure_Type);
    }

    public String toString(){
        return SPMeasureType_idSPMeasureType.getValue()+", " +SPFamily_idSPFamily.getValue()
                +Name_Family.getValue()+", "+Name_Measure_Type.getValue();
    }


    public static void main(String[] args) {
        SPFamily_has_SPMeasureType spFamily_has_SPMeasureType = new SPFamily_has_SPMeasureType();


        // Use Java Collections to create the List.
        List<SPFamily_has_SPMeasureType> list = new ArrayList<>();

        // Now add observability by wrapping it with ObservableList.
        ObservableList<SPFamily_has_SPMeasureType> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener() {

            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Detected a change! ");
            }
        });

        System.out.println("Size: "+observableList.size());
    }


}
