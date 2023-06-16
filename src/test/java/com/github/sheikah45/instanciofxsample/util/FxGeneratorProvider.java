package com.github.sheikah45.instanciofxsample.util;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;
import org.instancio.Node;
import org.instancio.generator.Generator;
import org.instancio.generator.GeneratorContext;
import org.instancio.generator.GeneratorSpec;
import org.instancio.generators.Generators;
import org.instancio.internal.generator.util.CollectionGenerator;
import org.instancio.internal.generator.util.MapGenerator;
import org.instancio.spi.InstancioServiceProvider;

import java.util.HashMap;
import java.util.Map;

public class FxGeneratorProvider implements InstancioServiceProvider.GeneratorProvider {

    private final GeneratorContext generatorContext;

    private static final Map<Class<?>, Generator<?>> GENERATOR_MAP = new HashMap<>();

    static {
        GENERATOR_MAP.put(StringProperty.class, (Generator<StringProperty>) random ->
                new SimpleStringProperty(random.upperCaseAlphabetic(random.intRange(3, 10))));

        GENERATOR_MAP.put(LongProperty.class, (Generator<LongProperty>) random ->
                new SimpleLongProperty(random.longRange(1, 10000)));
    }

    FxGeneratorProvider(final GeneratorContext generatorContext) {
        this.generatorContext = generatorContext;
    }

    @Override
    public GeneratorSpec<?> getGenerator(Node node, Generators generators) {

        Class<?> klass = node.getTargetClass();
        Generator<?> generator = GENERATOR_MAP.get(klass);

        if (generator != null) {
            return generator;
        }

        // observable collections
        if (klass == ObservableList.class || klass == ObservableSet.class) {
            return new CollectionGenerator<>(generatorContext);
        } else if (klass == ObservableMap.class) {
            return new MapGenerator<>(generatorContext);
        }

        return null;
    }


}
