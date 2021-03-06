package it.unicas.SensiplusConfigurationManager.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.List;
public class SPFamily {

    private StringProperty idSPFamily;
    private StringProperty name;
    private StringProperty id;
    private StringProperty hwVersion;
    private StringProperty sysclock;
    private StringProperty osctrim;



    public SPFamily(String idSPFamily,String name,String id,String hwVersion,String sysclock,String osctrim) {
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleStringProperty(id);
        this.hwVersion = new SimpleStringProperty(hwVersion);
        this.sysclock = new SimpleStringProperty(sysclock);
        this.osctrim = new SimpleStringProperty(osctrim);

        if ( idSPFamily != null){
            this.idSPFamily = new SimpleStringProperty(idSPFamily);
        } else {
            this.idSPFamily = null;
        }

    }

    public SPFamily(String name,String id,String hwVersion,String sysclock,String osctrim) {
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleStringProperty(id);
        this.hwVersion = new SimpleStringProperty(hwVersion);
        this.sysclock = new SimpleStringProperty(sysclock);
        this.osctrim = new SimpleStringProperty(osctrim);
    }

    public SPFamily() {
        this("","","","","","");
    }

    public SPFamily(String idSPFamily, String name) {
        this.idSPFamily = new SimpleStringProperty(idSPFamily);
        this.name=new SimpleStringProperty(name);

    }


    public String getidSPFamily() {
        if (idSPFamily == null){
            idSPFamily = new SimpleStringProperty(null);
        }
        return idSPFamily.get();
    }


    public void setIdSPFamily(String idSPFamily) {
        if (this.idSPFamily == null){
            this.idSPFamily = new SimpleStringProperty();
        }
        this.idSPFamily.set(idSPFamily);
    }

    public StringProperty IdSPFamilyProperty() {
        return idSPFamily;
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

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getHwVersion() {
        return hwVersion.get();
    }

    public StringProperty hwVersionProperty() {
        return hwVersion;
    }

    public void setHwVersion(String hwVersion) {
        this.hwVersion.set(hwVersion);
    }

    public String getSysclock() {
        return sysclock.get();
    }

    public StringProperty sysclockProperty() {
        return sysclock;
    }

    public void setSysclock(String sysclock) {
        this.sysclock.set(sysclock);
    }

    public String getOsctrim() {
        return osctrim.get();
    }

    public StringProperty osctrimProperty() {
        return osctrim;
    }

    public void setOsctrim(String osctrim) {
        this.osctrim.set(osctrim);
    }

    public String toString(){
        return name.getValue()+", " +id.getValue()+", "+ hwVersion.getValue()+", "+ sysclock.getValue()+", "+
                osctrim.getValue()+", "+ idSPFamily.getValue();
    }


    public static void main(String[] args) {
        SPFamily spFamily = new SPFamily();


        // Use Java Collections to create the List.
        List<SPFamily> list = new ArrayList<>();

        // Now add observability by wrapping it with ObservableList.
        ObservableList<SPFamily> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener() {

            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Detected a change! ");
            }
        });

        System.out.println("Size: "+observableList.size());
    }
}
