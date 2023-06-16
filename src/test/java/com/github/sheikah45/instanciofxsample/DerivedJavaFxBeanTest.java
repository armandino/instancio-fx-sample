package com.github.sheikah45.instanciofxsample;

import org.instancio.Instancio;
import org.instancio.assignment.AssignmentType;
import org.instancio.assignment.OnSetMethodNotFound;
import org.instancio.assignment.SetterStyle;
import org.instancio.junit.InstancioExtension;
import org.instancio.junit.WithSettings;
import org.instancio.settings.Keys;
import org.instancio.settings.Settings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(InstancioExtension.class)
class DerivedJavaFxBeanTest {

    @WithSettings
    private static final Settings SETTINGS = Settings.create()
                                                     .set(Keys.ASSIGNMENT_TYPE, AssignmentType.METHOD)
                                                     .set(Keys.SETTER_STYLE, SetterStyle.SET)
                                                     .set(Keys.ON_SET_METHOD_NOT_FOUND, OnSetMethodNotFound.IGNORE);

    @Test
    void testGeneration() {
        var derivedBean = Instancio.create(DerivedJavaFxBean.class);

        assertNotNull(derivedBean.getSource());
        assertTrue(derivedBean.getDerived() > 0);
    }

}