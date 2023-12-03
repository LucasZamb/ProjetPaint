import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public abstract class Figure implements Serializable {
    protected Point origin;
    protected Color color;
    protected int length;  //x size
    protected int width;  //y size

    public Figure(Point origin, Color color) {
        this.origin = origin;
        this.color = color;
        this.width = 0;
        this.length = 0;
    }

    //Bounding box definition
    public void setBoundingBox(int heightBB, int widthBB) {
        this.length = widthBB ;
        this.width = heightBB;
    }

    //Method for drawing the figure
    public abstract void draw(Graphics g);

    //Method for surface
    public abstract double getSurface();

    //Method for perimeter
    public abstract double getPerimeter();


    //Getter
    public Point getOrigin() {
        return origin;
    }

    public Color getColor(){
        return color;
    }


    //toString method
    @Override
    public String toString() {
        return "Figure{origin=" + "(" + origin.getX() + "," + origin.getY() + ")" + ", color=" + color + '}';
    }
}
