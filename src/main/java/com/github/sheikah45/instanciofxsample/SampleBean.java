package com.github.sheikah45.instanciofxsample;

import javafx.beans.property.ListProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;

public class SampleBean {
    private final StringProperty sourceProperty = new SimpleStringProperty();
    private final LongProperty longValue = new SimpleLongProperty();
    private final ObservableValue<Integer> derivedProperty = sourceProperty.map(String::length);
    private final ObservableMap<String, String> mapObservable = FXCollections.observableHashMap();
    private final ObservableList<String> listObservable = FXCollections.observableArrayList();
    private final ObservableSet<String> setObservable = FXCollections.observableSet();
    private final ListProperty<String> listValue = new SimpleListProperty<>();

    public ObservableList<String> getListValue() {
        return listValue.get();
    }

    public String getSource() {
        return sourceProperty.get();
    }

    public StringProperty sourceProperty() {
        return sourceProperty;
    }

    public Integer getDerived() {
        return derivedProperty.getValue();
    }

    public ObservableValue<Integer> derivedProperty() {
        return derivedProperty;
    }

    public long getLongValue() {
        return longValue.get();
    }

    public ObservableMap<String, String> getMapObservable() {
        return mapObservable;
    }

    public ObservableList<String> getListObservable() {
        return listObservable;
    }

    public ObservableSet<String> getSetObservable() {
        return setObservable;
    }
}
