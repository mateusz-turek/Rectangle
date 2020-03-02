package Java.Model;

public class Rectangle {
    private int height;
    private int length;

    private static Rectangle rectangle;

    private Rectangle(int height, int length) {
        if (rectangle!=null){
            throw new IllegalStateException();
        }
        this.height = height;
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    private void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    private void setLength(int length) {
        this.length = length;
    }

    public static Rectangle getInstanceOfRectangle() {
        if (rectangle == null){
            rectangle = new Rectangle(0,0);
        }
        return rectangle;
    }

    @Override
    public String toString() {
        return "Actual value of Rectangle {" +
                "height=" + height +
                ", length=" + length +
                '}';
    }
}
