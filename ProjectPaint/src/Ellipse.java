import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.lang.Math;



public class Ellipse extends Figure{
    private int width = 0;
    private int length = 0;
    private int SemiAxysX = 0;
    private int SemiAxysY = 0;

    public Ellipse(int px , int py , Color c ){
        super(new Point(px , py), c);
    }

    public void setBoundingBox(int heightBB, int widthBB){
        this.width = widthBB ;
        this.length = heightBB;
        this.SemiAxysX = widthBB/2;
        this.SemiAxysY = heightBB/2;

    }


    public void draw(Graphics g) {

        g.setColor(getColor());
        g.fillOval((int) getOrigin().getX() ,(int) getOrigin().getY(),length,width);
    }

    public double getSurface() {
        return Math.PI*(length/2)*(width/2);
    }

    public double getPerimeter() {
        return Math.PI*Math.sqrt(2*((length/2)*(length/2)+(width/2)*(width/2)));
    }

    public void setSemiAxysX(int SemiAxysX){
        this.SemiAxysX= SemiAxysX;
    }

    public void setSemiAxysY(int SemiAxysXY){
        this.SemiAxysY= SemiAxysY;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "width=" + width +
                ", length=" + length +
                ", SemiAxysX=" + SemiAxysX +
                ", SemiAxysY=" + SemiAxysY +
                '}';
    }
}
