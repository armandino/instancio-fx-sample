package com.github.sheikah45.instanciofxsample;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import org.instancio.Assign;
import org.instancio.Assignment;
import org.instancio.Instancio;
import org.instancio.junit.InstancioExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(InstancioExtension.class)
class SampleTest {

    @Test
    void usingCurrentAPIs() {
        var result = Instancio.create(SampleBean.class);

        assertNotNull(result.getSource());

        assertFalse(result.getSetObservable().isEmpty());
        assertFalse(result.getMapObservable().isEmpty());
        assertFalse(result.getListObservable().isEmpty());
    }

    /**
     * Setting observables should be possible with the new assign() API method
     * which will be available in the next major release.
     */
    @Test
    void usingV3APIs() {
        final Assignment[] assignments = {
                Assign.valueOf(SampleBean::sourceProperty)
                        .to(SampleBean::derivedProperty)
                        .as((StringProperty p) -> p.map(String::length)),

                Assign.valueOf(SampleBean::getListObservable)
                        .to(SampleBean::getListValue)
                        .as((ObservableList<String> l) -> new SimpleListProperty<>(l))
        };

        var result = Instancio.of(SampleBean.class)
                .assign(assignments)
                .create();

        assertNotNull(result.getSource());
        assertTrue(result.getDerived() > 0);
        assertEquals(result.getDerived(), result.getSource().length());
        assertTrue(result.getLongValue() > 0);

        assertFalse(result.getSetObservable().isEmpty());
        assertFalse(result.getMapObservable().isEmpty());
        assertFalse(result.getListObservable().isEmpty());
        assertFalse(result.getListValue().isEmpty());
    }
}