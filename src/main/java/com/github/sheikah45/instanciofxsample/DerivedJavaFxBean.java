package com.github.sheikah45.instanciofxsample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class DerivedJavaFxBean {
    private final StringProperty sourceProperty = new SimpleStringProperty();
    private final ObservableValue<Integer> derivedProperty = sourceProperty.map(String::length);

    public String getSource() {
        return sourceProperty.get();
    }

    public StringProperty sourceProperty() {
        return sourceProperty;
    }

    public void setSource(String source) {
        this.sourceProperty.set(source);
    }

    public Integer getDerived() {
        return derivedProperty.getValue();
    }

    public ObservableValue<Integer> derivedProperty() {
        return derivedProperty;
    }
}
