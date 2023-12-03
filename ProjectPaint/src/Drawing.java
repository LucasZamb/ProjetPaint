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

public class Drawing extends JPanel {//implements MouseListener, MouseMotionListener
    private ArrayList<Figure> figures;
    private Color currentColor;
    private Figure currentFigure;
    private Point startPoint;
    private Rectangle rectangle;
    private Circle circle;

    public Drawing() {
        figures = new ArrayList<>();
        currentColor = Color.BLACK;
        currentFigure = rectangle;
        //addMouseListener(this);
        //addMouseMotionListener(this);

    }


    public void mouseClicked(MouseEvent e) {
        // pour le clique gauche
    }

    private void MousePressed(MouseEvent e){
        startPoint = e.getPoint();
        if (currentFigure.equals("Rectangle")) {
            currentFigure = new Rectangle(0, 0, currentColor);
        } else if (currentFigure.equals("Ellipse")) {
            currentFigure = new Ellipse(0, 0, currentColor);
        } else if (currentFigure.equals("Circle")) {
            currentFigure = new Circle(0, 0, currentColor);
        } else if (currentFigure.equals("Square")) {
            currentFigure = new Square(0, 0, currentColor);
        }
        if(currentFigure != null){
            setColor(currentColor);
        }
    }

    private void MouseReleased(MouseEvent e){
        if (currentFigure != null){
            addFigure(currentFigure);
            currentFigure = null ;
        }
    }
    public void mouseDragged(MouseEvent e) {
        if (currentFigure != null) {
            int witdh = e.getX() - startPoint.x;
            int height = e.getY() -startPoint.y;
            //currentFigure.setWidth(witdh);
            //currentFigure.setHeight(height);
            repaint();
        }
    }
    public void setColor(Color color) {
        this.currentColor = color;
    }

    public void setNameFigure(Figure figure) {
        this.currentFigure = figure;
    }

    public void addFigure(Figure figure){
        figures.add(figure);
    }

    public ArrayList<Figure> getFigures() {
        return figures;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Figure figure : figures){
            figure.draw(g);
        }
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
