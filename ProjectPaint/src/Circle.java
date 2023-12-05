import java.awt.Color;


public class Circle extends Ellipse {
    public Circle(int px, int py ,Color c) {
        super(px, py, c);
    }

    //New way to set the bounding box
    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        super.setBoundingBox(heightBB, heightBB);
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