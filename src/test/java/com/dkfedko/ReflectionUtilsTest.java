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
        System.out.println(person);
    }
    @Test
    void shouldFindMethodsWithNoParameters() {

       Person  person = new Person();
       reflectionUtils.showMethodsWithNoParameters(person);
       assertNotNull(person);

    }
    @Test
    void shouldFindMethodsWithFinalModifiers() {

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

        person.setName("Danylo");
        person.age = 26;
        person.setWeight(100);
        person.salary = 100;

        person.calculateOvertimes(21, 45, 2);

        reflectionUtils.changePrivateFieldsToDefaultValue(person);
        System.out.println(person);
    }

    @Test
    void shouldRunAnnotatedMethods(){

        Person person = new Person();
        reflectionUtils.getRunAnnotatedMethods(person);

    }
}