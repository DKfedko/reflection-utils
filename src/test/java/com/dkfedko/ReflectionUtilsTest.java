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
    void shouldFindMethodsWithNoParameters() throws IllegalAccessException {

       Person person = new Person();
       person.name = " Danylo";
       person.salary = " $100";
       person.age = 23;
       person.weight = 100;

       reflectionUtils.showMethodsWithNoParameters(person);
       reflectionUtils.showNonPublicMethods(Person.class);
       reflectionUtils.changePrivateFieldsToNull(person);
       reflectionUtils.showMethodsWithFinal(person);
       reflectionUtils.showAllParentClassAndInterfaces(Person.class);

    }
    @Test
    void shouldInvokeMethodsWithFinalModifiers(){



       // reflectionUtils.invokeMethodsWithFinal(person);

    }
}