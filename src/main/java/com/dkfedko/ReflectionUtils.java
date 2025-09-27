package com.dkfedko;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class ReflectionUtils {

    public <T> T createObject(Class<T> clazz)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return clazz.getDeclaredConstructor().newInstance();
    }

    public <T> void getMethodsWithNoParameters(T object) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getParameterCount() == 0) {
                method.setAccessible(true);
                Object result = method.invoke(object);
                System.out.println(method.getName() + result);
            }
        }
    }

    public <T> void invokeMethodsWithFinal(T object) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()){
            if (Modifier.isFinal(method.getModifiers()))
                System.out.println(method.getName());
        }
    }

    public <T> void invokeNonPublicMethods(T Class){


    }
    public <T> void setPrivateFieldsAsNull (T object){

    }
}

