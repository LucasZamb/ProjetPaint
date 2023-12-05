import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Figure{
    private int width ;
    private int length ;

    public Rectangle(int px, int py, Color c) {
        super(new Point(px, py), c);
    }

    public Rectangle(Point origin, Color color) {
        super(origin, color);
    }

    public void setBoundingBox(int heightBB, int widthBB) {
        this.width =widthBB ;
        this.length = heightBB;
    }

    //Method for drawing the figure
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect((int)getOrigin().getX(),(int)getOrigin().getY(),length ,width);
    }

    //Method for surface
    public double getSurface(){
        return length*width;
    }

    //Method for perimeter
    public double getPerimeter(){
        return 2*length+2*width;
    }

    //Getter
    public int getLength(){
        return length;
    }

    public int getWidth(){
        return width;
    }

    //Setter
    public void setLength(int length){
        this.length = length;
    }

    public void setWidth(int width){
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "origin=" + origin +
                ", color=" + color +
                ", length=" + length +
                ", width=" + width +
                '}';
    }
}
