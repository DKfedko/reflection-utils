package com.dkfedko;

import com.dkfedko.anotation.Run;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionUtils {
    public <T> T createObject(Class<T> clazz)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return clazz.getDeclaredConstructor().newInstance();
    }

    public <T> void showMethodsWithNoParameters(T object) {
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getParameterCount() == 0) {
                method.setAccessible(true);
                System.out.println(method.getName());
            }
        }
    }
    public <T> void showMethodsWithFinal(T object) {
        Class<?> clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isFinal(method.getModifiers()))
                System.out.println(method.getName());
        }
    }
    public <T> void showNonPublicMethods(Class<T> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            method.getModifiers();
            if (!Modifier.isPublic(method.getModifiers())) {
                method.setAccessible(true);
                System.out.println(method.getName());
            }
        }
    }
   public <T> void showAllParentClassAndInterfaces(Class<T> clazz){
        Class<?> classes = clazz.getSuperclass();
        while (classes !=null){
            System.out.println(classes.getName());
            classes  = classes.getSuperclass();
        }
        Class<?> [] interfaces = clazz.getInterfaces();
        for (Class<?> interfacezz : interfaces) {
            System.out.println(interfacezz.getName());
        }
}
    public <T> void changePrivateFieldsToDefaultValue (T object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            Class<?> type = field.getType();
            if (type.isPrimitive()) {
                if (type == boolean.class) {
                    field.setBoolean(object, false);
                }
                if (type == int.class) {
                    field.setInt(object, 0);
                }
                if (type == long.class) {
                    field.setLong(object, 0);
                }
                if (type == byte.class) {
                    field.setByte(object, (byte) 0);
                }
                if (type == double.class) {
                    field.setDouble(object, 0.0d);
                }
                if (type == short.class) {
                    field.setShort(object, (short) 0);
                }
                if (type == char.class) {
                    field.setChar(object, '\u0000');
                }
                if (type == float.class) {
                    field.setFloat(object, 0.0f);
                }
            } else {
                field.set(object, null);
            }
            System.out.println(field.getName());
        }
    }
    public <T> void getRunAnnotatedMethods(T object) {
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            if (method.isAnnotationPresent(Run.class))
                System.out.println(method.getName());
        }
    }
//     public void changePrivateFieldsToDefaultValue  {
//    }
//    public <T> void injectAnnotatedFields(T object) {
//        Field[] fields = object.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            field.setAccessible(true);
//            if (field.isAnnotationPresent(Inject.class)) {
//                field.set(object.())
//                System.out.println();
//            }
//        }
//    }
}
