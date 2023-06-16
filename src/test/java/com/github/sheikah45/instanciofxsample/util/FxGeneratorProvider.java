package com.github.sheikah45.instanciofxsample.util;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.SetProperty;
import javafx.beans.property.StringProperty;
import org.instancio.Node;
import org.instancio.generator.GeneratorSpec;
import org.instancio.generators.Generators;
import org.instancio.spi.InstancioServiceProvider;

public class FxGeneratorProvider implements InstancioServiceProvider.GeneratorProvider {

    @Override
    public GeneratorSpec<?> getGenerator(Node node, Generators generators) {
        Class<?> klass = node.getTargetClass();
        if (BooleanProperty.class.equals(klass)) {
            return generators.booleans();
        } else if (StringProperty.class.isAssignableFrom(klass)) {
            return generators.string();
        } else if (LongProperty.class.isAssignableFrom(klass)) {
            return generators.longs();
        } else if (IntegerProperty.class.isAssignableFrom(klass)) {
            return generators.ints();
        } else if (DoubleProperty.class.isAssignableFrom(klass)) {
            return generators.doubles();
        } else if (FloatProperty.class.isAssignableFrom(klass)) {
            return generators.floats();
        } else if (MapProperty.class.isAssignableFrom(klass)) {
            return generators.map();
        } else if (SetProperty.class.isAssignableFrom(klass)) {
            return generators.collection();
        } else if (ListProperty.class.isAssignableFrom(klass)) {
            return generators.collection();
        }

        return null;
    }
}
