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

       Person person = new Person();
       person.name = " Danylo";
       person.salary = " $100";
       person.age = 23;
       person.weight = 100;

       reflectionUtils.showMethodsWithNoParameters(Person.class);

    }
    @Test
    void shouldFindMethodsWithFinalModifiers(){



       // reflectionUtils.invokeMethodsWithFinal(person);

    }
    @Test
    void shouldShowAllSuperClasses(){

    }
}