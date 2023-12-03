public class Point {
    private int x;
    private int y;

    //First Constructor
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    //Second Constructor
    public Point(int xOrigin, int yOrigin){
        this.x = xOrigin;
        this.y = yOrigin;
    }

    //Getter method
    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }

    //Setter method
    public void setX(int xOrigin){
        this.x=xOrigin;
    }

    public void setY(int yOrigin){
        this.y=yOrigin;
    }

    //toString method
    @Override
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}
