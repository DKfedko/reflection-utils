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
       person.setName("Dania");
       person.setSalary("$300");
       person.setAge(23);
       person.setWeight(100);

        reflectionUtils.showMethodsWithNoParameters(person);

    }
    @Test
    void shouldFindMethodsWithFinalModifiers(){

        Person person = new Person();

        person.setName("Olia");
        person.setSalary("$280");
        person.setAge(25);
        person.setWeight(120);
        person.calculateOvertimes(26, 38, 1.48);
        reflectionUtils.showMethodsWithFinal(person);
        System.out.println(person);

    }
    @Test
    void shouldShowAllSuperClasses(){
        reflectionUtils.showAllParentClassAndInterfaces(Person.class);
    }
    @Test
    void shouldShowNonPublicMethods(){
        reflectionUtils.showNonPublicMethods(Person.class);
    }
//    @Test
//    void shouldCheckIfPrivateFieldsSetToDefault(){
//
//        reflectionUtils.
//    }
    
}