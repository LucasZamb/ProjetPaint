import java.awt.Point;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class Drawing extends JPanel implements MouseListener, MouseMotionListener {
    private ArrayList<Figure> figures;
    private Color currentColor;
    private String currentFigure;
    private int x;
    private int y;


    public Drawing() {
        figures = new ArrayList<>();
        currentColor = Color.BLACK;
        currentFigure = "Rectangle";
        addMouseListener(this);
        addMouseMotionListener(this);

    }


    public void setColor(Color color) {
        this.currentColor = color;
    }

    public void setNameFigure(String currentFigure) {
        this.currentFigure = currentFigure;
    }

    public void addFigure(Figure figure){
        figures.add(figure);
    }

    public ArrayList<Figure> getFigures() {
        return figures;
    }


    public void mouseClicked(MouseEvent e){
    }

    public void mouseMoved(MouseEvent e){
    }

    public void mouseDragged(MouseEvent e){
        figures.get(figures.size()-1).setBoundingBox(e.getX()-x,e.getY()-y);
        paintComponent(this.getGraphics());

    }


    public void mouseEntered(MouseEvent e){
    }

    public void mouseExited(MouseEvent e){
    }

    public void mousePressed(MouseEvent e){
        this.x=e.getX();
        this.y=e.getY();

        switch (currentFigure){
            case "Square" : figures.add(new Square(x,y,currentColor));
                break;
            case "Rectangle" : figures.add(new Rectangle(x,y,currentColor));
                break;
            case "Circle" : figures.add(new Circle(x,y,currentColor));
                break;
            case "Ellipse" : figures.add(new Ellipse(x,y,currentColor));
                break;
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Figure figure : figures){
            figure.draw(g);
            this.repaint();
        }
    }

    public void mouseReleased(MouseEvent e){
        figures.get(figures.size()-1).setBoundingBox(e.getX()-x,e.getY()-y);
        paintComponent(this.getGraphics());
    }


    //Method to save a figure
    public void saveFigures() {

        //creating a file selector
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Sauvegarder les figures");
        //User choice
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            //Files writing
            try (FileOutputStream fos = new FileOutputStream(fileToSave);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                oos.writeObject(figures);
                System.out.println("Figures sauvegardées dans " + fileToSave.getAbsolutePath());
            } catch (Exception e) {
                System.out.println("Problème de sauvegarde");
            }
        }
    }


    public void loadFigures() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Ouvrir les figures");
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToLoad = fileChooser.getSelectedFile();

            try (FileInputStream fis = new FileInputStream(fileToLoad);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {

                figures = (ArrayList<Figure>) ois.readObject();
                repaint();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Method to erase the drawing
    public void clearDrawing() {
        figures.clear();
        repaint();
    }

}
