package com.dkfedko;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class ReflectionUtilsTest {
    ReflectionUtils reflectionUtils = new ReflectionUtils();

    @Test
    void shouldCreateNewInstance() throws
            InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException {

        Person person = reflectionUtils.createObject(Person.class);
        assertNotNull(person);
        assertEquals(Person.class, person.getClass());
    }
    @Test
    void shouldFindMethodsWithNoParameters() {

       Person  person = new Person();
       reflectionUtils.showMethodsWithNoParameters(person);
       assertNotNull(person);
       System.out.println(person);

    }
    @Test
    void shouldFindMethodsWithFinalModifiers(){

        Person person  = new Person();
        reflectionUtils.showMethodsWithFinal(person);

    }
    @Test
    void shouldShowAllSuperClasses(){

        reflectionUtils.showAllParentClassAndInterfaces(Person.class);

    }
    @Test
    void shouldShowNonPublicMethods(){

        reflectionUtils.showNonPublicMethods(Person.class);

    }
    @Test
    void shouldCheckIfPrivateFieldsSetToDefault() throws IllegalAccessException {

        Person person = new Person();

        reflectionUtils.changePrivateFieldsToDefaultValue(person);
    }
    @Test
    void shouldRunAnnotatedMethods(){

        Person person = new Person();
        reflectionUtils.getRunAnnotatedMethods(person);

    }
}