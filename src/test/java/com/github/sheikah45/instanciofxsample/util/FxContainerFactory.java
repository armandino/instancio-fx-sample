package com.github.sheikah45.instanciofxsample.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;
import org.instancio.internal.spi.InternalContainerFactoryProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FxContainerFactory implements InternalContainerFactoryProvider {

    private static final Map<Class<?>, Function<?, ?>> FN_MAP = new HashMap<>();

    static {
        FN_MAP.put(ObservableList.class, FXCollections::observableArrayList);
        FN_MAP.put(ObservableSet.class, FXCollections::observableSet);
        FN_MAP.put(ObservableMap.class, (Function<Map, ObservableMap<?, ?>>) FXCollections::observableMap);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <S, T> Function<S, T> getMappingFunction(final Class<T> klass, final List<Class<?>> typeArgs) {
        return (Function<S, T>) FN_MAP.get(klass);
    }

    @Override
    public boolean isContainer(final Class<?> klass) {
        return FN_MAP.containsKey(klass);
    }
}
