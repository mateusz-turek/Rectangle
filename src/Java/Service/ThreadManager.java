package Java.Service;

import Java.Model.Rectangle;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager  {

    private RectangleService rectangleService;

    private void executeChangeHeightOfRectangle() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.println("Type rectangle height");
        Scanner sc = new Scanner(System.in);
        this.rectangleService = RectangleServiceImplementation::accessToSetRectangleHeight;
        rectangleService.changeParam(sc.nextInt());
    }

    private void executeChangeLengthOfRectangle() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.println("Type rectangle length");
        Scanner sc = new Scanner(System.in);
        this.rectangleService = RectangleServiceImplementation::accessToSetRectangleLength;
        rectangleService.changeParam(sc.nextInt());
    }

    public void run() {

        Thread calculateArea = new Thread(()-> System.out.println("Area: "+ Rectangle
                .getInstanceOfRectangle().getHeight()*Rectangle.getInstanceOfRectangle().getLength()));

        Thread getRectangular = new Thread(()-> System.out.println(Rectangle.getInstanceOfRectangle()));

        Thread changeLength = new Thread(()->{
            try {
                executeChangeLengthOfRectangle();
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        Thread changeHeight = new Thread(()-> {
            try {
                executeChangeHeightOfRectangle();
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(getRectangular);
        executorService.submit(changeLength);
        executorService.submit(getRectangular);
        executorService.submit(changeHeight);
        executorService.submit(getRectangular);
        executorService.submit(calculateArea);
        executorService.submit(getRectangular);
        executorService.shutdown();

    }

}
