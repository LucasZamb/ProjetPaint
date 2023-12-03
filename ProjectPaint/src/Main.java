import java.awt.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args){
        Window window = new Window("Paint" , 800 , 800);
        window.setVisible(true);
        Rectangle rectangle = new Rectangle(new Point(500,90) , Color.black);
        rectangle.setBoundingBox(1000,1000);
        window.addFigure(rectangle);
        Circle circle = new Circle(0, 50, Color.RED);
        circle.setBoundingBox(90);
        window.addFigure(circle);
    }
}