package Java.Service;

import java.lang.reflect.InvocationTargetException;

@FunctionalInterface
public interface RectangleService {
     void changeParam(int param) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
}
