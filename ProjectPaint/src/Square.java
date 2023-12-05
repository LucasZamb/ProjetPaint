import java.awt.Color;

public class Square extends Rectangle {
    public Square(int px, int py, Color c) {
        super(px, py, c);
    }

    //New way to set the bounding box
    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        super.setBoundingBox(heightBB, heightBB);
    }

    @Override
    public void setLength(int length) {
        super.setLength(length);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
    }
}