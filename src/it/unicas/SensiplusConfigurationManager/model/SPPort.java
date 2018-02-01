package it.unicas.SensiplusConfigurationManager.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SPPort {

    private StringProperty internal;
    private StringProperty name;

    public SPPort(String internal, String name) {
        this.internal = new SimpleStringProperty(internal);
        this.name = new SimpleStringProperty(name);
    }

    public String getInternal() {
        return internal.get();
    }

    public StringProperty internalProperty() {
        return internal;
    }

    public void setInternal(String internal) {
        this.internal.set(internal);
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
}
