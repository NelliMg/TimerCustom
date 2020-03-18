package com.company;

import javax.xml.crypto.Data;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Something s = new Something();
        Method[] methods = Something.class.getDeclaredMethods();
        for (int i = 0; i < s.getClass().getDeclaredMethods().length; i++) {
            Annotation[] annotations = methods[i].getAnnotations();
            boolean annotated=false;
            for (int j = 0; j < annotations.length; j++) {
                if (annotations[j] instanceof Timer) {
                    long start;
                    try {
                        System.out.println("starting the method  " + methods[i].getName());
                        start = new Date().getTime();
                        methods[i].invoke(s);
                        System.out.println("the method was execute in  " + (new Date().getTime() - start));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    annotated=true;
                    break;
                }
            }
            if(!annotated){
                try {
                    methods[i].invoke(s);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
