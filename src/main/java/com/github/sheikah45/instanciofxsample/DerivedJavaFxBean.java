package com.github.sheikah45.instanciofxsample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class DerivedJavaFxBean {
    private final StringProperty source = new SimpleStringProperty();
    private final ObservableValue<Integer> derived = source.map(String::length);

    public String getSource() {
        return source.get();
    }

    public StringProperty sourceProperty() {
        return source;
    }

    public void setSource(String source) {
        this.source.set(source);
    }

    public Integer getDerived() {
        return derived.getValue();
    }

    public ObservableValue<Integer> derivedProperty() {
        return derived;
    }
}
