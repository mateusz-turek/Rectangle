package Java.Service;

import Java.Model.Rectangle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class RectangleServiceImplementation {

    static void accessToSetRectangleHeight(int height) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method setRectangleHeight = Rectangle.class.getDeclaredMethod("setHeight", int.class);
        setRectangleHeight.setAccessible(true);
        setRectangleHeight.invoke(Rectangle.getInstanceOfRectangle(),height);
        setRectangleHeight.setAccessible(false);
    }

    static void accessToSetRectangleLength(int length) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method setRectangleLength = Rectangle.class.getDeclaredMethod("setLength", int.class);
        setRectangleLength.setAccessible(true);
        setRectangleLength.invoke(Rectangle.getInstanceOfRectangle(),length);
        setRectangleLength.setAccessible(false);
    }



}
