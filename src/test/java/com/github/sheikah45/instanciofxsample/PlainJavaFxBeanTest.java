package com.github.sheikah45.instanciofxsample;

import org.instancio.Instancio;
import org.instancio.assignment.AssignmentType;
import org.instancio.assignment.OnSetMethodNotFound;
import org.instancio.assignment.SetterStyle;
import org.instancio.junit.WithSettings;
import org.instancio.settings.Keys;
import org.instancio.settings.Settings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlainJavaFxBeanTest {

    @WithSettings
    private static final Settings SETTINGS = Settings.create()
                                                     .set(Keys.ASSIGNMENT_TYPE, AssignmentType.METHOD)
                                                     .set(Keys.SETTER_STYLE, SetterStyle.SET)
                                                     .set(Keys.ON_SET_METHOD_NOT_FOUND, OnSetMethodNotFound.IGNORE);

    @Test
    void testGeneration() {
        var plainBean = Instancio.create(PlainJavaFxBean.class);

        assertNotNull(plainBean.getStringValue());
        assertNotNull(plainBean.getDateValue());
        assertTrue(plainBean.getDoubleValue() != 0);
        assertTrue(plainBean.getFloatValue() != 0);
        assertTrue(plainBean.getLongValue() != 0);
        assertTrue(plainBean.getIntegerValue() != 0);
        assertFalse(plainBean.getListValue().isEmpty());
        assertFalse(plainBean.getSetValue().isEmpty());
        assertFalse(plainBean.getMapValue().isEmpty());
        assertNotNull(plainBean.getListObservable());
        assertNotNull(plainBean.getSetObservable());
        assertNotNull(plainBean.getMapObservable());
    }
}