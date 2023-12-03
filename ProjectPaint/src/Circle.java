import java.awt.Color;


public class Circle extends Ellipse {
    public Circle(int px, int py ,Color c) {
        super(px, py, c);
    }


    public void setBoundingBox(int diameter) {
        super.setBoundingBox(diameter, diameter);
    }

    @Override
    public void setSemiAxysX(int SemiAxysX) {
        super.setSemiAxysX(SemiAxysX);
    }

    @Override
    public void setSemiAxysY(int SemiAxysXY) {
        super.setSemiAxysY(SemiAxysXY);
    }
}